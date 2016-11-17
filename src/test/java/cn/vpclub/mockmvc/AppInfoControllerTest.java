package cn.vpclub.mockmvc;

import cn.vpclub.api.domain.AppInfo;
import cn.vpclub.api.model.response.BaseResponse;
import cn.vpclub.api.model.response.PageDataResponse;
import cn.vpclub.common.utils.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by admin on 2016/3/29.
 */
public class AppInfoControllerTest extends BaseMockMvcTest {

    /**
     * 保存与修改应用系统信息
     *
     * @throws Exception
     */
    @Test
    public void TestSaveDataInfo() throws Exception {
        String uri = "/common/appInfo/saveDataInfo";
        MvcResult result = null;
        String inputJson = null;
        String content = null;
        BaseResponse response = null;
        //新增
        List<Map<String, Object>> configList = new ArrayList<Map<String, Object>>();
        Map<String, Object> configMap = new HashMap<String, Object>();
        configMap.put("serviceType", 5);
        configMap.put("callUrl", "http://api.supay.vpclub.cn/pay");
        configMap.put("callbackUrl", "http://api.supay.vpclub.cn/notify");
        configMap.put("remarks", "应用系统支付服务");
        configList.add(configMap);
        Map<String, Object> dataInfoMap = new HashMap<String, Object>();
        dataInfoMap.put("appId", 20000105);
        dataInfoMap.put("appName", "应用系统主题");
        dataInfoMap.put("configList", configList);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", merchantToken);
        map.put("dataInfo", dataInfoMap);

        inputJson = JsonUtil.objectToJson(map);
        logger.info("保存应用系统信息paramMap: " + inputJson);
        result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isOk())
                .andReturn();

        content = result.getResponse().getContentAsString();

        logger.info("保存应用系统信息测试返回：" + content);
        response = JsonUtil.jsonToObject(content, BaseResponse.class);
        Assert.assertEquals(response.getReturnCode().toString(), "1000");

        // 获取应用系统信息
        AppInfo resDataInfo = JsonUtil.jsonToObject(
                JsonUtil.objectToJson(response.getDataInfo()), AppInfo.class);
        resDataInfo.setAppName("修改应用系统主题");
        map.put("dataInfo", resDataInfo);

        inputJson = JsonUtil.objectToJson(map);
        logger.info("修改应用系统信息paramMap: " + inputJson);
        result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isOk())
                .andReturn();

        content = result.getResponse().getContentAsString();

        logger.info("保存修改应用系统信息测试返回：" + content);
        response = JsonUtil.jsonToObject(content, BaseResponse.class);
        Assert.assertEquals(response.getReturnCode().toString(), "1000");

        // 获取应用系统信息
        AppInfo dataInfo = JsonUtil.jsonToObject(
                JsonUtil.objectToJson(response.getDataInfo()), AppInfo.class);
        String dataId = dataInfo.getId();
        map = new HashMap<String, Object>();
        map.put("dataId", dataId);
        map.put("token", merchantToken);

        uri = "/common/appInfo/deleteDataInfo";
        inputJson = JsonUtil.objectToJson(map);
        logger.info("根据主键ID删除应用系统信息paramMap: " + inputJson);
        result = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isOk())
                .andReturn();

        content = result.getResponse().getContentAsString();

        logger.info("根据主键ID删除应用系统信息测试返回：" + content);
        response = JsonUtil.jsonToObject(content, BaseResponse.class);
        Assert.assertEquals(response.getReturnCode().toString(), "1000");
    }

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
