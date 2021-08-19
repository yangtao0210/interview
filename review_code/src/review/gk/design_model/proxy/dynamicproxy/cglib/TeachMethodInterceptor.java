package review.gk.design_model.proxy.dynamicproxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TeachMethodInterceptor implements MethodInterceptor {
    private Class<?> target;
    public TeachMethodInterceptor(Class<?> target){
        this.target = target;
    }

    public Object getProxyInstance() {
        // 为代理类指定需要代理的类，也即是父类
        Enhancer enhancer = new Enhancer();
        // 设置方法拦截器回调引用，对于代理类上所有方法的调用，
        // 都会调用 CallBack，而 Callback 则需要实现 intercept() 方法进行拦截
        enhancer.setSuperclass(target);
        // 获取动态代理类对象并返回
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Long startTimestamp = System.currentTimeMillis();

        Object result = proxy.invokeSuper(obj, args);

        Long endTimeStamp = System.currentTimeMillis();
        Long teachTime = endTimeStamp - startTimestamp;
        System.out.println("Time: " + teachTime);
        return result;
    }

}
