package day6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
public class OneLineBridge {
    public static void main(String[] args)
    {
        final Bridge bridge = new Bridge();

        Thread thEastbound = new Thread( new Runnable() {

            @Override
            public void run() {

                while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);
                    Thread th = new Thread(vehicle);
                    vehicle.setName("East Vehicle : "+th.getId());
                    th.start();
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
                }

            }
        });

        Thread thWestbound = new Thread( new Runnable() {

            @Override
            public void run() {

                while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);
                    Thread th = new Thread(vehicle);
                    vehicle.setName("West Vehicle : "+th.getId());
                    th.start();
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
                }
            }
        });

        thEastbound.start();
        thWestbound.start();
    }
}


class Bridge {
    private final Semaphore semaphore;

    public Bridge() {
        semaphore = new Semaphore(1);
    }
    public void crossBridge(Vehicle vehicle) {
        try
        {
            System.out.printf("Vehicle %s is trying to cross the bridge.\n",vehicle.getName());
            semaphore.acquire();
            System.out.printf("Vehicle %s is crossing the bridge.\n",vehicle.getName());
            long duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        finally
        {
            System.out.printf("Vehicle %s has crossed the bridge.\n",vehicle.getName());
            semaphore.release();
        }
    }
}

class Vehicle implements Runnable
{
    private String name;
    private Bridge bridge;

    public Vehicle(Bridge bridge)
    {
        this.bridge = bridge;
    }

    public void run()
    {
        bridge.crossBridge(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
