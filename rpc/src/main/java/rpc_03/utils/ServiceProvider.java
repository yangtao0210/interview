package rpc_03.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * @author YT
 * @deprecated 存放接口名和对应的实现类信息（一个实现类可能实现多个接口）
 */
public class ServiceProvider {
    private Map<String,Object> interfaceProvider;
    public ServiceProvider(){
        this.interfaceProvider = new HashMap<>();
    }

    /**
     * 构造实现类和调用接口的对应关系
     * @param service
     */
    public void provideServiceInteface(Object service){
        Class<?>[] interfaces = service.getClass().getInterfaces();
        for(Class c : interfaces){
            interfaceProvider.put(c.getName(),service);
        }
    }

    /**
     * 根据接口名称获取相应的实现类
     * @param interfaceName
     * @return
     */
    public Object getService(String interfaceName){
        return interfaceProvider.get(interfaceName);
    }
}
