package rpc_02.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author YT
 * @deprecated 封装服务端返回的数据格式
 */
@Builder
@Data
public class RPCResponse implements Serializable {

    //状态码
    private int code;
    //消息
    private String message;
    //具体数据
    private Object data;

    //请求成功
    public static RPCResponse success(Object data){
        return RPCResponse.builder()
                .code(200)
                .data(data)
                .build();
    }
    //请求失败
    public static RPCResponse fail(){
        return RPCResponse.builder().code(500).message("服务器内部错误").build();
    }
}
