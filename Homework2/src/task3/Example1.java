package task3;

public class Example1
{
    public static void main(String[] args) throws InterruptedException
    {
        Consumer consumer = new Consumer();
        Producer producer = new Producer(consumer);

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();
    }
}
