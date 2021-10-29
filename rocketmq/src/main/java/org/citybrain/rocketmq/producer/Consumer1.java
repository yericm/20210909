package org.citybrain.rocketmq.producer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;


/**
 * @author yeric
 * @description:
 * @date 2021/10/26 13:49
 */
public class Consumer1 {
    public static void main(String[] args) throws InterruptedException, MQClientException {
        DefaultMQPushConsumer consumerGroup = new DefaultMQPushConsumer("cg-test");
        consumerGroup.setNamesrvAddr("127.0.0.1:9876");
        consumerGroup.subscribe("topic-test", "tag-a");
        consumerGroup.registerMessageListener(
                new MessageListenerConcurrently() {
                    @Override
                    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                        for (MessageExt msg : msgs) {
                            System.out.println(new String(msg.getBody()));
                        }
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                });
        consumerGroup.setConsumeThreadMax(1);// 设置最大线程数
        consumerGroup.setConsumeThreadMin(1);// 设置最小线程数
        // 集群模式还是广播模式
//        consumerGroup.setMessageModel(MessageModel.BROADCASTING);
        consumerGroup.start();
        System.out.println("consumerGroup1026-1启动了");
    }
}
