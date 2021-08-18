package interview.mq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import interview.mq.utils.RabbitMQUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Privoder {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {

        Connection connection = RabbitMQUtils.getConnection();
        //获取链接对象的通道并将其与对应的消息队列绑定:一个通道可以绑定多个队列
        Channel channel = connection.createChannel();

        //为通道声明指定的交换机
        /**
         * 参数1：交换机名称
         * 参数2： 交换机类型
         */
        channel.exchangeDeclare("logs","fanout");
        //获取链接对象
        //发布消息:交换机名称、队列名称，额外设置，传递内容
        for(int i = 0; i < 20; i++){
            channel.basicPublish("logs","", null,(i +"fanout message").getBytes());
        }
        RabbitMQUtils.close(channel,connection);
    }
}
