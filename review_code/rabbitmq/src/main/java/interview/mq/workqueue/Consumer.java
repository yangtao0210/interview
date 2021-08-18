package interview.mq.workqueue;

import com.rabbitmq.client.*;
import interview.mq.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
//    @Test
//    public void consumerMessage() throws IOException, TimeoutException {
//
//    }
public static void main(String[] args) throws IOException, TimeoutException {
    new Thread(new ConsumerThread("消费者-1")).start();
    new Thread(new ConsumerThread("消费者-2")).start();
}
static class ConsumerThread implements Runnable{
    String name = null;
    public ConsumerThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        //获取链接对象
        Connection connection = null;
        //获取链接对象的通道并将其与对应的消息队列绑定
        Channel channel = null;
        try {
            connection = RabbitMQUtils.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare("work",true,false,false,null);

            //设置每次消费1个消息:关闭自动确认机制，需要手动确认
            channel.basicQos(1);
            //消费消息:交换机名称、队列名称，额外设置，传递内容
            Channel finalChannel = channel;
            channel.basicConsume("work",false,new DefaultConsumer(finalChannel){
                @Override //body消息队列中取出的消息
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println(name+ "消费：" + new String(body));
                    finalChannel.basicAck(envelope.getDeliveryTag(),false);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
