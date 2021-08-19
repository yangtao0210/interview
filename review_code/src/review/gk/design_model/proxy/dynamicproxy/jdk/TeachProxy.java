package review.gk.design_model.proxy.dynamicproxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TeachProxy {
    private Object target;

    public TeachProxy(Object target) {
        this.target = target;
    }

    public Object getInstance() {

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Long startTimestamp = System.currentTimeMillis();
                        Object invoke = method.invoke(target, args);

                        Long endTimeStamp = System.currentTimeMillis();
                        Long teachTime = endTimeStamp - startTimestamp;
                        System.out.println("Time: " + teachTime);
                        return invoke;
                    }
                }
        );
    }
}
