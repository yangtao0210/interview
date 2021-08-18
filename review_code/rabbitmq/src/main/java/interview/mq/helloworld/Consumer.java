package interview.mq.helloworld;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.rabbitmq.client.*;
import interview.mq.utils.RabbitMQUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
//    @Test
//    public void consumerMessage() throws IOException, TimeoutException {
//
//    }
public static void main(String[] args) throws IOException, TimeoutException {
    new Thread(new ConsumerThread(),"线程1").start();
    new Thread(new ConsumerThread(),"线程2").start();
}
static class ConsumerThread implements Runnable{

    @Override
    public void run() {
        //获取链接对象
        Connection connection = null;
        //获取链接对象的通道并将其与对应的消息队列绑定
        Channel channel = null;
        try {
            connection = RabbitMQUtils.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare("hello",true,false,true,null);

            //消费消息:交换机名称、队列名称，额外设置，传递内容
            channel.basicConsume("hello",true,new DefaultConsumer(channel){
                @Override //body消息队列中取出的消息
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println(Thread.currentThread().getName()+ "消费：" + new String(body));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
