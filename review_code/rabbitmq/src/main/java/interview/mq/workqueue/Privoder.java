package interview.mq.workqueue;

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
        //参数1：队列名称,若不存在自动创建
        //参数2：durable,是否持久化
        //参数3：exclusive，是否独占:是否多个通道可绑定同一个队列
        //参数4：autoDelete,是否在消费完后自动删除
        channel.queueDeclare("work",true,false,false,null);
        //获取链接对象
        for(int i = 0 ;i < 1000;i++){
            //发布消息:交换机名称、队列名称，额外设置，传递内容
            channel.basicPublish("","work", MessageProperties.PERSISTENT_TEXT_PLAIN,(i+"work queue message").getBytes());
        }
        RabbitMQUtils.close(channel,connection);
    }
}
