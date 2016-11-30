package cn.vpclub.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    protected Logger logger = LoggerFactory.getLogger(Listener.class);
    public final CountDownLatch count = new CountDownLatch(1);

    @KafkaListener(topics = "${kafka.topic}", group = "${kafka.group}")
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("consumer back data is "+record.toString());
        count.countDown();
    }

}