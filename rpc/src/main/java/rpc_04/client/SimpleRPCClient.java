package rpc_04.client;

import lombok.AllArgsConstructor;
import rpc_04.common.RPCRequest;
import rpc_04.common.RPCResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//不同的网络方式有不同的实现
@AllArgsConstructor
public class SimpleRPCClient implements RPCClient {
    private String host;
    private int port;

    //客户端发起请求调用：Socket建立连接，发起Request，得到响应Response
    @Override
    public RPCResponse sendRequest(RPCRequest request) {
        try{
            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println(request);
            oos.writeObject(request);
            oos.flush();
            RPCResponse response  = (RPCResponse) ois.readObject();
            return response;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
