package rpc_03.service;

import rpc_03.common.Blog;

public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        System.out.println("客户端查看了 第"+id+"篇博客");
        return Blog.builder()
                .id(id)
                .useId(22)
                .title("MY BLOG...")
                .build();
    }
}
