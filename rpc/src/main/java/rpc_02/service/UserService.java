package rpc_02.service;

import rpc_02.common.User;

public interface UserService {
    User getUserByUserId(Integer id);

    Integer insertUser(User user);
}
