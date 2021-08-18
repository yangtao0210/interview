package interview.mq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
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
        channel.exchangeDeclare("topics","topic");
        String routingKey = "user.save";
        String routingKey_1 = "admin.save";
        String routingKey_2 = "user.save.update";
        //发送消息
        channel.basicPublish("topics",routingKey, null,("topic 动态路由模型 RoutingKey : ["+routingKey+"]").getBytes());
        channel.basicPublish("topics",routingKey_1, null,("topic 动态路由模型 RoutingKey_1 : ["+routingKey_1+"]").getBytes());
        channel.basicPublish("topics",routingKey_2, null,("topic 动态路由模型 RoutingKey_2 : ["+routingKey_2+"]").getBytes());

        RabbitMQUtils.close(channel,connection);
    }
}
