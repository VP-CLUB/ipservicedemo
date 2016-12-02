package cn.vpclub.mockmvc;

/**
 * Created by  vpclub on 16-11-28.
 * PackageName cn.vpclub.mockmvc
 * ModifyDate  16-11-28
 * Description (to do)
 * ProjectName ipservicedemo
 */

import cn.vpclub.mq.kafka.Listener;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.TimeUnit;



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
                logger.info("success");
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("failed");
            }
        });
        logger.info(Thread.currentThread().getId()+"");
        Assert.assertNotSame(listener.baseResponse.getReturnCode(),1000);

    }

}
