package rpc_04.server;

/**
 * @author YT
 * @deprecated 定义服务端的抽象接口，开放封闭原则
 */
public interface RPCServer {
    void start(int port);
    void stop();
}
