package rpc_01.server;

import rpc_01.User;

/**
 * 客户端通过该接口调用服务端的实现类
 */
public interface UserService {
    User getUserByUserId(Integer id);
}
