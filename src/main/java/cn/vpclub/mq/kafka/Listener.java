package cn.vpclub.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by  vpclub on 16-11-29.
 * PackageName cn.vpclub.mq.kafka
 * ModifyDate  16-11-29
 * Description (to do)
 * ProjectName ipservicedemo
 */
public class Listener {

    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

    @KafkaListener(id = "foo", topics = "${kafka.topic}", group = "group1")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record);
        countDownLatch1.countDown();
    }

}