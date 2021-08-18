package interview.mq.fanout;

import com.rabbitmq.client.*;
import interview.mq.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer3 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //为通道绑定消费者发给消息的交换机
        channel.exchangeDeclare("logs","fanout");
        //交换机产生的临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定交换机和声明的队列
        channel.queueBind(queueName,"logs","");

        //消费消息
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者3 : "+new String(body));
            }
        });
    }
}
