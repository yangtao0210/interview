package rpc_03.test;

import rpc_03.common.User;
import rpc_03.service.UserService;
import rpc_03.client.ClientProxy;
import rpc_03.common.Blog;
import rpc_03.service.BlogService;

public class RPCClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1",9988);
        UserService proxy =  clientProxy.getProxy(UserService.class);
        //调用方法1
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("从服务器端得到的user===="+userByUserId);
        //调用方法2
        Integer insert = proxy.insertUser(User.builder().userName("ZS").id(100).sex(false).build());
        System.out.println("插入数据===="+insert);

        BlogService blogService = clientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(1000);
        System.out.println("从服务器端得到的blog===="+blogById);

    }
}
