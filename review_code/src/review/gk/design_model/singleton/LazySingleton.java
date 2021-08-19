package review.gk.design_model.singleton;

/**
 * 懒汉式：在外部调用时才会加载，线程不安全，可以加锁保证线程安全，但是效率低。
 */
public class LazySingleton {
    private LazySingleton(){}
    private static LazySingleton instance;
    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
