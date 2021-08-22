package rpc_01.server;

import rpc_01.User;

import java.util.Random;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        //模拟从数据库查询用户信息的行为
        System.out.println("RPC客户端查询了"+id+"的用户");
        Random random = new Random();
        User user = User.builder()
                .id(id)
                .userName(UUID.randomUUID().toString())
                .sex(random.nextBoolean()).build();
        return user;
    }
}
