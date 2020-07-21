package task2;

import task3.Consumer;
import task3.Producer;

public class Bridge {
    public static void main(String[] args) throws InterruptedException
    {
        LeftSideCar lsc = new LeftSideCar();
        RightSideCar rsc = new RightSideCar(lsc);

        lsc.start();
        rsc.start();

        rsc.join();
        lsc.join();
    }
}
