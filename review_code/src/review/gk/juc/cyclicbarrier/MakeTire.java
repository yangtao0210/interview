package review.gk.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MakeTire implements Runnable {
    private CyclicBarrier cyclicBarrier;
    public MakeTire(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        exec();
    }

    //模拟制造轮胎
    private void exec() {
        while(true){
            try{
                System.out.println("Start making tire...");
                long millis = ((int)(1+Math.random()*(5-1+1)))*1000;
                TimeUnit.MILLISECONDS.sleep(millis);
                System.out.println("Making tire is finished.");

                //等待其他部件造完
                this.cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
