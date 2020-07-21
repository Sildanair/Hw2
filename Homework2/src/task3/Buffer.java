package task3;

public class Buffer
{

    private static int count = 0;

    public static void produceItem() throws IllegalAccessException
    {
            count ++;
    }

    public static void consumeItem() throws IllegalAccessException
    {
        if (count!=0)
        {
            count --;
        }
        else
        {
            throw new IllegalAccessException("Нельзя потребить, так как товара нет.");
        }
    }
    public static int getCount(){return count;}
}
