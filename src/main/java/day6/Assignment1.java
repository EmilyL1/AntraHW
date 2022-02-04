package day6;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
//        q1();
        int[] a = {4,1,2,3};
        int[] b = {4,5,6};
//        q2(a,b);
        q3(a);
    }

    public static void q1(){
        Scanner sc = new Scanner(System.in);
        int x = 0;
        while(sc.hasNextInt()){
            x = sc.nextInt();
            try{
                if(x <= 0) throw new RuntimeException();
                if(x > 0){
                    for(int i = 0; i < x; i++){
                        doSomething(x);
                    }
                }
            }catch(RuntimeException e){
                System.out.println("Negative Number");
            }
        }

        if(sc.next().equals("q")){
            System.out.println("Bye");
            return;
        }
    }

    public static void doSomething(int x){
        System.out.println(new Date());
    }

    public static void q2(int[] a, int[] b){
        int[] res = new int[a.length+b.length];
        for(int i = 0; i < res.length; i++){
            if(i<a.length){
                res[i] = a[i];
            }else{
                res[i] = b[i-a.length];
            }
        }
        Arrays.stream(res).forEach(System.out::print);

    }
    public static void q3(int[] a){
        Arrays.sort(a);
        System.out.println(a[1]);

    }

}

