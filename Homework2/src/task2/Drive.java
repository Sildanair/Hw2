package task2;

import java.time.Duration;
import java.time.LocalTime;

public class Drive {
    private static int minTime = 1;
    private static int maxTime = 2;

    private static int count;
    private static LocalTime startTime;
    /*
    public Drive(int carCount){

        this.carCount = carCount;
    }
    //@Override

     */
    public static void drive(){

        System.out.println((count+1) + "-я машина начала движение. Время: " + Duration.between(getStartTime(),LocalTime.now()).toMillis() + "мс");
        double t = minTime+Math.random()*(maxTime-minTime);
        try{
            Thread.sleep((int) (t *1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime temp = LocalTime.now();
        System.out.println((count+1) + "-я машина завершила движение. Время: " + Duration.between(getStartTime(),temp).toMillis() + "мс");
        count++;
    }
    public static int getCount(){
        return count;
    }
    private static LocalTime getStartTime(){
        if (startTime==null){
            startTime = LocalTime.now();
        }
        return startTime;
    }

}
