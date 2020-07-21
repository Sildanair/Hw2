package task3;

public class Producer extends Thread
{
    private final Consumer consumer;

    public Producer(Consumer consumer)
    {
        this.consumer = consumer;
    }

    @Override
    public void run()
    {
        try
        {
            synchronized (Buffer.class)
            {
                for (int i = 1; i <= 1000; i++)
                {
                    Buffer.produceItem();
                    System.out.println("Товар произведен, количество товара: "+Buffer.getCount());
                    Buffer.class.notify();
                    if (Buffer.getCount()>11)
                    try
                    {
                        Buffer.class.wait();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                consumer.interrupt();
            }
        }
        catch (IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
