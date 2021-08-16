package review.gk.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MakeCarBody implements Runnable {
    private CyclicBarrier cyclicBarrier;
    public MakeCarBody(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        exec();
    }

    //模拟制造车身的过程：批量生产
    private void exec() {
        while(true){
            try{
                System.out.println("Start making car body...");
                long millis = ((int)(1+Math.random()*(5-1+1)))*1000;
                TimeUnit.MILLISECONDS.sleep(millis);
                System.out.println("Making car body is finished.");

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
