package rpc_03.server;

import lombok.AllArgsConstructor;
import rpc_03.common.RPCRequest;
import rpc_03.common.RPCResponse;
import rpc_03.utils.ServiceProvider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

@AllArgsConstructor
public class WorkThread implements Runnable {
    private Socket socket;
    private ServiceProvider serviceProvide;

    @Override
    public void run() {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //读取客户端传过来的request
            RPCRequest request = (RPCRequest) ois.readObject();
            //反射调用服务方法获得返回值
            RPCResponse response = getResponse(request);
            oos.writeObject(response);
            oos.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("IO 出现异常");
        }

    }

    /**
     * 解析请求信息返回响应结果
     * @param request
     * @return
     */
    private RPCResponse getResponse(RPCRequest request) {
        //得到服务接口名称
        String interfaceName = request.getInterfaceName();
        //根据服务名获取相应的实现类
        Object service = serviceProvide.getService(interfaceName);
        //根据request参数，并利用反射调用对应的方法
        Method method = null;
        try{
            //根据方法名称 & 参数类型确定唯一的方法
            method = service.getClass().getMethod(
                    request.getMethodName(),
                    request.getParamsTypes());
            //根据对象名 & 参数列表调用方法
            Object invoke = method.invoke(service, request.getParams());
            return RPCResponse.success(invoke);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("方法执行出错");
            return RPCResponse.fail();
        }
    }
}
