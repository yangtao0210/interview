package review.gk.design_model.singleton;

/**
 * 枚举：避免线程安全问题 & 防止反序列化重新创建新的对象 & 防止反射破解单例
 */
public enum  EnumSingleton {
    INSTANCEOF;
}
