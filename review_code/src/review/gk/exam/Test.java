package review.gk.exam;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Test {
    private static int num = 0;

    public static void main(String[] args) {
        Inner.method();
        System.out.println(num);
        HashSet<Object> objects = new HashSet<>();
    }

    static class Inner{
        public static void method(){
            num ++;
        }
    }
}
