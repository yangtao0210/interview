package review.gk.design_model.proxy.dynamicproxy.jdk;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Teach teach = (Teach) (new TeachProxy(new TeachImpl()).getInstance());
        teach.doTeach();
    }
}
