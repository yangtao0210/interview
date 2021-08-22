package rpc_02.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author YT
 * 定义传输对象:服务端和客户端共用
 */
@Data
@Builder
public class User implements Serializable {
    private Integer id;
    private String userName;
    private Boolean sex;
}
