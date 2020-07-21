package task2;

import task2.Drive;
import task2.LeftSideCar;

public class RightSideCar extends Thread {

    private final LeftSideCar lsc;

    public RightSideCar(LeftSideCar lsc)
    {
        this.lsc = lsc;
    }

    @Override
    public void run()
    {

        synchronized (Drive.class)
        {
            for (;Drive.getCount()<21;)
            {
                Drive.drive();
                Drive.class.notify();
                if (Drive.getCount() % 5 == 0)
                    try
                    {
                        System.out.println("\n Начало движения с левой стороны \n");
                        Drive.class.wait();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
            lsc.interrupt();
        }
    }
}

