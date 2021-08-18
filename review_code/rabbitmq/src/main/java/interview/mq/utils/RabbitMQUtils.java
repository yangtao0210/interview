package interview.mq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtils {
    //工厂只需要创建一次；类加载时初始化即可(使用静态代码块)
    private static  ConnectionFactory connectionFactory;
    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("81.68.195.140");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //设置访问该虚拟主机的用户名和密码
        connectionFactory.setUsername("guaika");
        connectionFactory.setPassword("guaika@0210");
    }
    //获取连接
    public static Connection getConnection()  {
        Connection connection = null;
        try{
            connection = connectionFactory.newConnection();
        }catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取链接对象
       return connection;
    }

    //关闭通道 & 连接
    public static void close(Channel channel, Connection conn){
        try{
            if(channel != null){
                channel.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
