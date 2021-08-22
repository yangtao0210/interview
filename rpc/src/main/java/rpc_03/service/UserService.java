package rpc_03.service;


import rpc_03.common.User;

public interface UserService {
    User getUserByUserId(Integer id);

    Integer insertUser(User user);
}
