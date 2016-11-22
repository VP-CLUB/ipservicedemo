package cn.vpclub.mockmvc;

import cn.vpclub.api.model.response.PageDataResponse;
import cn.vpclub.common.utils.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by admin on 2016/3/29.
 */
public class AppInfoControllerTest extends BaseMockMvcTest {


    /**
     * 查询应用系统信息列表
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        String uri = "/common/appInfo/findDataPage";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageNumber", 1);
        paramMap.put("pageSize", 10);
        paramMap.put("token", merchantToken);
        String inputJson = JsonUtil.objectToJson(paramMap);
        logger.info("查询应用系统信息列表paramMap: " + inputJson);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertNotNull(content);
        logger.info("查询应用系统信息列表测试返回：" + content);

        PageDataResponse response = JsonUtil.jsonToObject(content, PageDataResponse.class);
        Assert.assertEquals(response.getReturnCode().toString(), "1000");
    }


}
