package com.example2.demo2.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {
    /**
     * 生产组，生产者必须在生产组内
     */
    private String producerGroup = "newTest_group";

    /**
     * nameSrv IP及端口
     */
    private String nameSrv = "118.190.215.76:9876";

    /**
     * topic
     */
    private static final String topic = "my_topic_test01";

    private DefaultMQPushConsumer consumer;

    public MyConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(producerGroup);
        consumer.setNamesrvAddr(nameSrv);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.subscribe(topic, "*");
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            try {
                Message message = msgs.get(0);
                System.out.println("%s Receive New Messages: %s %n" + Thread.currentThread().getName() + new String(msgs.get(0).getBody()));
                String topic = message.getTopic();
                String body = new String(message.getBody(), "utf-8");
                String tags = message.getTags();
                String keys = message.getKeys();
                System.out.println("topic=" + topic + ",tags=" + tags + ",keys=" + keys + ",body=" + body);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        consumer.start();
    }
}
