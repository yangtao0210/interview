package rpc_02.client;

import rpc_02.common.User;
import rpc_02.service.UserService;

public class RPCClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1",9988);
        UserService proxy =  clientProxy.getProxy(UserService.class);
        //调用方法1
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("调用getUserByUserId方法===="+userByUserId);
        //调用方法2
        Integer insert = proxy.insertUser(User.builder().userName("ZS").id(100).sex(false).build());
        System.out.println("插入数据===="+insert);

    }
}
