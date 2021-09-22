package review.gk.exam.zt;

import java.io.Serializable;
import java.util.*;

public class ZT1 extends Thread implements Serializable {
    public enum Dogs{one,two,three};
    private int x = 2;
    private String name;
    public static void main(String[] args) throws Exception {
        System.out.println('a'+0);
    }
    public ZT1(String name){
        this.name = name;
    }

    public void write(){
        System.out.print(name);
        System.out.print(name);
    }
    public void go() throws Exception{
        join();
        x = x-1;
        System.out.println(x);
    }

    @Override
    public  synchronized void run(){
        synchronized (System.out){
            write();
        }
    }
    public static Iterator reverse(List list){
        Collections.reverse(list);
        return list.iterator();
    }
}
