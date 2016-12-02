package cn.vpclub.mq.kafka;

import cn.vpclub.common.api.model.response.BaseResponse;
import cn.vpclub.common.tools.enums.ReturnCodeEnum;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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

    public BaseResponse baseResponse;

    @KafkaListener(topics = "${kafka.topic}", group = "${kafka.group}")
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("consumer back data is "+record.toString());
        count.countDown();
        baseResponse = new BaseResponse();
        try {
            if (this.count.await(60, TimeUnit.SECONDS)){
                baseResponse.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
                baseResponse.setMessage(ReturnCodeEnum.CODE_1000.getValue());
                baseResponse.setDataInfo(record);
            }
        }
        catch (Exception e){
            baseResponse.setReturnCode(ReturnCodeEnum.CODE_1005.getCode());
            baseResponse.setMessage(ReturnCodeEnum.CODE_1005.getValue());
        }
    }

}