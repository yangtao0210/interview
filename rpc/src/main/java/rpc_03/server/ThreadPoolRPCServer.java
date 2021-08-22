package rpc_03.server;

import rpc_03.utils.ServiceProvider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author YT
 * 实现线程池版本的服务器
 */
public class ThreadPoolRPCServer implements RPCServer {

    private ServiceProvider serviceProvide;
    private final ThreadPoolExecutor threadPool;

    public ThreadPoolRPCServer(ServiceProvider serviceProvide) {
        threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                1000,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
        this.serviceProvide = serviceProvide;
    }

    @Override
    public void start(int port) {
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了...");
            while(true){
                Socket socket = serverSocket.accept();
                //开启新线程处理任务
                new Thread(new WorkThread(socket,serviceProvide)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败...");
        }
    }

    @Override
    public void stop() {

    }
}
