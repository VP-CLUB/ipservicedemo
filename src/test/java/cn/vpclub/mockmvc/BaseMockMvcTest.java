package cn.vpclub.mockmvc;


import cn.vpclub.DemoApplication;
import cn.vpclub.api.model.response.BaseResponse;
import cn.vpclub.common.utils.JsonUtil;
import cn.vpclub.common.utils.StringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2016/3/11.
 * 基础测试 抽象类
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public abstract class BaseMockMvcTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext context;

    protected static String merchantToken;

    @Before
    public void setupMockMvc() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

}
