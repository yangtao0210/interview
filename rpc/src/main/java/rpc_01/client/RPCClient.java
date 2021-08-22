package rpc_01.client;

import rpc_01.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class RPCClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1",8899);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            //传输参数到服务器：发送请求
            objectOutputStream.writeInt(new Random().nextInt());
            objectOutputStream.flush();
            //处理响应结果
            User user = (User)objectInputStream.readObject();
            System.out.println("服务端返回User："+user);

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("RPC客户端请求失败");
        }
    }
}
