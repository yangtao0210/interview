package review.gk.design_model.singleton;

/**
 * 饿汉式：在类加载时就初始化创建单例对象，线程安全，无论是否使用创建的对象都可能会浪费内存
 */
public class HungrySingleton {

    private HungrySingleton(){}
    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return instance;
    }
}
