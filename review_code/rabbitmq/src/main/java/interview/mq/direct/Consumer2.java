package interview.mq.direct;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.rabbitmq.client.*;
import interview.mq.utils.RabbitMQUtils;

import java.io.IOException;

public class Consumer2 {
    /**
     * 1.获取mq连接
     * 2.根据创建的MQ连接获取channel;
     * 3.根据通道声明交换机
     * 4.获取声明的临时队列
     * 5.将队列和交换机绑定
     * 6.消费消息
     */
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_direct","direct");
        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue,"logs_direct","info");
        channel.queueBind(queue,"logs_direct","error");
        channel.queueBind(queue,"logs_direct","warning");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("INFO_ERROR_WARNINF_Consumor ："+new String(body));
            }
        });
    }

}
