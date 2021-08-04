package review.gk.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicTest {
    //不使用原子类操作：出现并发问题
//    public static int i = 0;
    //使用原子类操作:无并发问题
    public static AtomicInteger i = new AtomicInteger();
    public static void add(){
        for(int j = 0;j < 1000;j++){
            i.incrementAndGet();
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        new ThreadLocal<>();

    }

    public static void main(String[] args) throws InterruptedException {
        //存放1000个线程的数组
        Thread[] threads = new Thread[1000];
        for(int j = 0; j < 1000;j++){
            threads[j] = new Thread(()->{
                add();
            });
            threads[j].start();
        }

        //确保main线程在1000个线程执行完成后再执行
        for(Thread thread : threads){
            thread.join();
        }

        System.out.println(i);
    }

}
