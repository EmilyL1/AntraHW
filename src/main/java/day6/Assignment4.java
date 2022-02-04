package day6;

import java.io.*;
import java.util.concurrent.*;

public class Assignment4 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        ReaderThread reader = new ReaderThread(queue);
        WriterThread writer = new WriterThread(queue);

        new Thread(reader).start();
        new Thread(writer).start();
    }
}

class ReaderThread implements Runnable {

    protected BlockingQueue<String> blockingQueue = null;

    public ReaderThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("input.txt")));
            String buffer = null;
            while ((buffer = br.readLine()) != null ) {
                if (buffer.equals("")) continue;
                String[] s = buffer.split("\\s");
                int res = Integer.parseInt(s[0]);
                for(int i = 1; i < s.length; i++){
                    if(s[i].equals("+")){
                        res += Integer.parseInt(s[i+1]);
                    }
                    if(s[i].equals("-")){
                        res -= Integer.parseInt(s[i+1]);
                    }
                }
                String val = buffer + " = " + res;
                blockingQueue.put(val);
            }
            blockingQueue.put("EOF");  //When end of file has been reached

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
class WriterThread implements Runnable{

    protected BlockingQueue<String> blockingQueue = null;

    public WriterThread(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new File("output.txt"));

            while(true){
                String buffer = blockingQueue.take();
                //Check whether end of file has been reached
                if(buffer.equals("EOF")){
                    break;
                }
                writer.println(buffer);
            }


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch(InterruptedException e){

        }finally{
            writer.close();
        }

    }

}
