package review.gk.design_model.proxy.dynamicproxy.cglib;

public class CgLibTest {
    public static void main(String[] args) {
        TeachMethodInterceptor methodInterceptor = new TeachMethodInterceptor(Teach.class);
        Teach proxyInstance = (Teach) methodInterceptor.getProxyInstance();
        proxyInstance.doTeach();
    }
}
