package review.gk.juc.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        //先制造三个部件，然后组装汽车
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new AssembleCar());
        Thread bodyThread = new Thread(new MakeCarBody(cyclicBarrier));
        Thread doorThread = new Thread(new MakeCarDoor(cyclicBarrier));
        Thread tireThread = new Thread(new MakeTire(cyclicBarrier));

        bodyThread.start();
        doorThread.start();
        tireThread.start();

    }
}
