package interview.mq.topic;

import com.rabbitmq.client.*;
import interview.mq.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //1.为通道绑定消费者发给消息的交换机
        channel.exchangeDeclare("topics","topic");
        //2.生成临时队列
        String queueName = channel.queueDeclare().getQueue();
        //3.基于routine key 绑定交换机和声明的队列 (以通配符的形式绑定)
        channel.queueBind(queueName,"topics","*.save.*");
        channel.queueBind(queueName,"topics","*.save.#");
        //4.消费消息
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("topic 消费者 1 : "+new String(body));
            }
        });
    }
}
