package cn.vpclub.mockmvc;

import cn.vpclub.api.model.response.BaseResponse;
import cn.vpclub.api.model.response.PageDataResponse;
import cn.vpclub.common.utils.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
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
        assertEquals(response.getReturnCode().toString(), "1000");
    }
    @Test
    public void testCacheSave() throws Exception {
        String uri = "/common/appInfo/saveCache";
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("cacheKey","test" );
        paramMap.put("data","testvalue" );
        String inputJson = JsonUtil.objectToJson(paramMap);
        logger.info("保存cache值paramMap: " + inputJson);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertNotNull(content);
        logger.info("保存cache测试返回：" + content);

        BaseResponse response = JsonUtil.jsonToObject(content, BaseResponse.class);
        Assert.assertEquals(response.getReturnCode().toString(), "1000");
    }
    @Test
    public void testCacheGet() throws Exception {
        String uri = "/common/appInfo/getCache";
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("cacheKey","test" );
        String inputJson = JsonUtil.objectToJson(paramMap);
        logger.info("查询cache值paramMap: " + inputJson);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertNotNull(content);
        logger.info("查询cache测试返回：" + content);

        BaseResponse response = JsonUtil.jsonToObject(content, BaseResponse.class);
        assertEquals(response.getReturnCode().toString(), "1000");
    }

}
