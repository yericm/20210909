package org.citybrain.rocketmq.producer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author yeric
 * @description:
 * @date 2021/10/26 18:03
 */
public class OrderConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order_cg");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe("orderTopic1", "TagA || TagC || TagD");

        consumer.registerMessageListener(
                // MessageListenerConcurrently：这个会并发消费，即多线程消费
                // new MessageListenerOrderly(): 这个顺序消费，一个queue一个线程，多个queue多个线程
                new MessageListenerOrderly() {

                    Random random = new Random();

                    @Override
                    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                        context.setAutoCommit(true);
                        for (MessageExt msg : msgs) {
                            // 可以看到每个queue有唯一的consume线程来消费, 订单对每个queue(分区)有序
                            System.out.println("consumeThread=" + Thread.currentThread().getName() + "   queueId=" + msg.getQueueId() + ", content:" + new String(msg.getBody()));
                        }

                        try {
                            //模拟业务逻辑处理中...
                            TimeUnit.SECONDS.sleep(random.nextInt(10));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return ConsumeOrderlyStatus.SUCCESS;
                    }
                });
        consumer.setConsumeThreadMax(1);
        consumer.setConsumeThreadMin(1);

        consumer.start();

        System.out.println("Consumer Started.");
    }
}
