package rpc_03.client;

import rpc_03.common.RPCRequest;
import rpc_03.common.RPCResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 客户端底层的通信工具:负责与服务端进行通信
 * 发送请求：RPCRequest
 * 接收响应：RPCResponse
 */
public class IOClient {
    public static RPCResponse sendRequest(String host, int port, RPCRequest request){
        try{
            Socket socket = new Socket(host,port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("客户端发送请求："+request);
            oos.writeObject(request);
            oos.flush();
            RPCResponse response = (RPCResponse) ois.readObject();
            return response;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
