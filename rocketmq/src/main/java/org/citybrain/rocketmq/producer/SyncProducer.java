package org.citybrain.rocketmq.producer;


import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author yeric
 * @description:
 * @date 2021/10/25 14:30
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer pgOne = new DefaultMQProducer("pg-test");
        pgOne.setNamesrvAddr("127.0.0.1:9876");
        pgOne.start();
        // 一个应用尽可能用一个Topic，而消息子类型则可以用tags来标识。tags可以由应用自由设置，只有生产者在发送消息设置了tags，消费方在订阅消息时才可以利用tags通过broker做消息过滤：message.setTags("TagA")。
//        for (int i = 0; i < 10; i++) {
        Message message = new Message("topic-test", "tag-a", UUID.randomUUID().toString(), ("[topic is permission]角色(roleId=1)更改关联的权限点" + 123).getBytes(StandardCharsets.UTF_8));
        SendResult sendResult = pgOne.send(message);
        System.out.println(sendResult);
//        }

        pgOne.shutdown();
    }
}
