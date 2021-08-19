package review.gk.design_model.publish;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    //是否生产
    private volatile boolean isRunning = true;
    //公共资源
    private final Vector sharedQueue;
    //公共资源的最大数量
    private final int SIZE;

    //生产数据
    private static AtomicInteger count = new AtomicInteger();

    public Producer(Vector sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        int data;
        Random r = new Random();
        System.out.println("Start producer id = "+Thread.currentThread().getId());
        try {
            //生产者生产数据
            while(isRunning){
                //模拟延迟
                Thread.sleep(r.nextInt(1000));

                //当队列满时，阻塞等待
                while(sharedQueue.size() == SIZE){
                    synchronized (sharedQueue){
                        System.out.println("Queue is full, producer " + Thread.currentThread().getId()
                                + " is waiting, size：" + sharedQueue.size());
                        sharedQueue.wait();
                    }
                }
                //队列不满时，继续生产元素
                synchronized (sharedQueue){
                    data = count.incrementAndGet();
                    sharedQueue.add(data);
                    System.out.println("producer create data:" + data + ", size：" + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
