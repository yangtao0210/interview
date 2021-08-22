package rpc_02.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author YT
 * @deprecated 封装客户端的请求格式：包括请求的接口、方法名、参数列表 和 参数类型
 */
@Data
@Builder
public class RPCRequest implements Serializable {
    //服务类名，客户端只知道接口名
    private String interfaceName;
    //方法名称
    private String methodName;
    //参数列表
    private Object[] params;
    //参数类型
    private Class<?>[] paramsTypes;
}
