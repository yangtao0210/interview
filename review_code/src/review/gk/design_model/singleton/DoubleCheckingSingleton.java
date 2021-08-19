package review.gk.design_model.singleton;

/**
 * 双重检查锁：使用volatile及多重检查来减小锁范围，提升效率
 */
public class DoubleCheckingSingleton {
    private DoubleCheckingSingleton(){}

    private volatile static DoubleCheckingSingleton instance;

    public static DoubleCheckingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckingSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckingSingleton();
                }
            }
        }
        return instance;
    }
}
