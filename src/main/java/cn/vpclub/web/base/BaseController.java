package cn.vpclub.web.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by  vpclub on 16-6-30.
 * PackageName cn.vpclub.traffic.monetisation.adapter.consumer
 * ModifyDate  16-6-30
 * Description (to do)
 * ProjectName vp-traffic-monetisation-adapter
 */
@RestController
//@Scope("prototype")
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


}
