package review.gk.design_model.singleton;

/**
 * 静态内部类：解决饿汉式的内存浪费 和 懒汉式的线程安全问题
 */
public class StaticSingleton {
    private StaticSingleton(){}

    public static StaticSingleton getInstance(){
        return StaticClass.instance;
    }

    private static class StaticClass {
        private static final StaticSingleton instance = new StaticSingleton();
    }
}
