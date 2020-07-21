package task2;

import task2.Drive;

public class LeftSideCar extends Thread{

    @Override
    public void run()
    {

        synchronized (Drive.class)
        {
            while (!isInterrupted() && Drive.getCount()<21)
            {
                Drive.drive();
                Drive.class.notify();
                if (Drive.getCount() % 5 == 0)
                    try
                    {
                        System.out.println("\n Начало движения с правой стороны \n");
                        Drive.class.wait();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                Drive.class.notify();
            }
        }


    }
}
