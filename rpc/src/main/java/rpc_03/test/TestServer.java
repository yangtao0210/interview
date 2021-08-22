package rpc_03.test;

import rpc_03.server.RPCServer;
import rpc_03.server.SimpleRPCServer;
import rpc_03.server.ThreadPoolRPCServer;
import rpc_03.service.BlogService;
import rpc_03.service.BlogServiceImpl;
import rpc_03.service.UserService;
import rpc_03.service.UserServiceImpl;
import rpc_03.utils.ServiceProvider;

import java.util.HashMap;
import java.util.Map;

public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        //暴露两个服务接口
//        serviceProvide.put("rpc_03.service.UserService",userService);
//        serviceProvide.put("rpc_03.service.BlogService",blogService);
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInteface(userService);
        serviceProvider.provideServiceInteface(blogService);
        RPCServer rpcServer = new ThreadPoolRPCServer(serviceProvider);
        rpcServer.start(9988);
    }
}
