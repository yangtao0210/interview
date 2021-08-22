package rpc_02.service;

import rpc_02.common.User;

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

    @Override
    public Integer insertUser(User user) {
        System.out.println("插入数据成功"+user);
        return 1;
    }
}
