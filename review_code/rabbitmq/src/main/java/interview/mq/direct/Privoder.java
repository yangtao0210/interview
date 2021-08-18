package interview.mq.direct;

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
        channel.exchangeDeclare("logs_direct","direct");
        String routingKey = "info";
        String routintKey_error = "error";
        /**
         * 生产者如何保证数据的可靠传输
            方式1：事务
             * 1.开启事务：channel.txSelect();
             * 2.发送消息
             * 3.若出现异常：回滚事务channel.txRollback() 并重新发送；
             * 4.若发送成功，则提交事务channel.txCommit().
            方式 2:confirm模式
         */
        //发送消息
        channel.basicPublish("logs_direct",routingKey, null,("This is a published  information message that is based on the model of Direct`s ["+routingKey+"]").getBytes());
        channel.basicPublish("logs_direct",routintKey_error, null,("This is a published  Error message that is based on the model of Direct`s ["+routintKey_error+"]").getBytes());
        RabbitMQUtils.close(channel,connection);
    }
}
