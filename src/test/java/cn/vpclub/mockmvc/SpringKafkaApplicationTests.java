package cn.vpclub.mockmvc;

/**
 * Created by  vpclub on 16-11-28.
 * PackageName cn.vpclub.mockmvc
 * ModifyDate  16-11-28
 * Description (to do)
 * ProjectName ipservicedemo
 */

import cn.vpclub.mq.kafka.Listener;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;


public class SpringKafkaApplicationTests extends BaseMockMvcTest{

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Listener listener;

    @Test
    public void contextLoads() throws InterruptedException {

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic1", "ABC");
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("addCallback success");
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("addCallback failed");
            }
        });
        logger.info("progress id is :  "+Thread.currentThread().getId());
        assertEquals(this.listener.count.await(1000, TimeUnit.SECONDS), true);
    }

}
