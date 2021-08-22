package rpc_01.server;

import rpc_01.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCServer {
    private static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(8899);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        try{
            System.out.println("RPC服务端启动,等待客户端连接....");
            while(true){
                //接收客户端的连接
                Socket socket = serverSocket.accept();
                //开启线程去处理客户端的请求
                new Thread(()->{
                    try{
                        //构建网络传输通道
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        //接收数据
                        int id = ois.readInt();
                        System.out.println("RPC客户端"+id+"连接成功，开始处理请求....");
                        User userByUserId = userService.getUserByUserId(id);
                        oos.writeObject(userByUserId);
                        oos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("IO 传输异常");
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器端启动出错...");
        }
    }
}
