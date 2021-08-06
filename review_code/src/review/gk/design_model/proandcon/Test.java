package review.gk.design_model.proandcon;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //构建内存缓存池
        Vector sharedQueue = new Vector();
        int size = 10;

        //建立线程池
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer1 = new Producer(sharedQueue,size);
        Producer producer2 = new Producer(sharedQueue,size);
        Producer producer3 = new Producer(sharedQueue,size);
        Consumer consumer1 = new Consumer(sharedQueue);
        Consumer consumer2 = new Consumer(sharedQueue);
        Consumer consumer3 = new Consumer(sharedQueue);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        // 3.睡一会儿然后尝试停止生产者(结束循环)
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        //休眠之后关闭线程池
        Thread.sleep(10 * 1000);

        service.shutdown();

    }
}
