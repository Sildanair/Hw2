package task3;

public class Consumer extends Thread
{
    @Override
    public void run()
    {
        try
        {
            synchronized (Buffer.class)
            {
                while (!isInterrupted())
                {
                    try
                    {
                        if (Buffer.getCount()==0)
                        {
                            System.out.println("Товара нет, ждем");
                            Buffer.class.wait();
                        }
                    }
                    catch (InterruptedException e)
                    {
                        if (Buffer.getCount()==0)
                        {
                            Buffer.consumeItem();
                            Buffer.class.notify();
                        }
                        return;
                    }
                    Buffer.consumeItem();
                    System.out.println("Товар потреблен, количество товара: "+Buffer.getCount());
                    Buffer.class.notify();
                }
            }
        }
        catch (IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
