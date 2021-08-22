package rpc_03.service;

import rpc_02.common.User;
import rpc_03.common.Blog;

public interface BlogService {
    Blog getBlogById(Integer id);
}
