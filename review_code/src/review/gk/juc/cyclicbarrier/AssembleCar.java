package review.gk.juc.cyclicbarrier;

import java.util.concurrent.TimeUnit;

public class AssembleCar implements Runnable{
    //模拟组装过程
    @Override
    public void run() {
        try {
            System.out.println("Start assemble car...");

            //模拟组装汽车
            long millis = ((int)(1+Math.random()*(5-1+1))) * 1000;
            TimeUnit.MILLISECONDS.sleep(millis);
            System.out.println("Making assemble care is finished.");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
