package cn.vpclub.mockmvc;

import cn.vpclub.ipaddress.api.model.response.BaseResponse;
import cn.vpclub.ipaddress.api.model.response.PageDataResponse;
import cn.vpclub.common.tools.utils.JsonUtil;
import cn.vpclub.ipaddress.service.impl.CacheManageServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by admin on 2016/3/29.
 */
public class AppInfoControllerTest extends BaseMockMvcTest {

    @Autowired
    private CacheManageServiceImpl cacheManageService;

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
        String content = post(uri,inputJson);
        logger.info("查询应用系统信息列表测试返回：" + content);

        PageDataResponse response = JsonUtil.jsonToObject(content, PageDataResponse.class);
        Assert.assertNotSame(response.getReturnCode().toString(), "1000");
    }
    @Test
    public void testCacheSave() throws Exception {
        String uri = "/common/appInfo/saveCache";
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("cacheKey","test" );
        paramMap.put("data","testvalue" );
        String inputJson = JsonUtil.objectToJson(paramMap);
        logger.info("保存cache值paramMap: " + inputJson);
        String content = post(uri,inputJson);
        logger.info("保存cache测试返回：" + content);

        BaseResponse response = JsonUtil.jsonToObject(content, BaseResponse.class);
        Assert.assertNotSame(response.getReturnCode().toString(), "1000");
    }
    @Test
    public void testCacheGet() throws Exception {
        String uri = "/common/appInfo/getCache";
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("cacheKey","test" );
        String inputJson = JsonUtil.objectToJson(paramMap);
        logger.info("查询cache值paramMap: " + inputJson);
        String content = post(uri,inputJson);
        logger.info("查询cache测试返回：" + content);
        BaseResponse response = JsonUtil.jsonToObject(content, BaseResponse.class);
        Assert.assertNotSame(response.getReturnCode().toString(), "1000");
    }
    @Test
    public void cacheTest() throws Exception {
        String username = "13337998888";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id",1);
        paramMap.put("status",1);
        paramMap.put("username",username);
//        User user = new User();
//        BeanUtils.copyProperties(user, request);
//
//        BeanUtils.copyProperties(dest, user);
//
//        logger.info("json is " + JsonUtil.objectToJson(user));
//        logger.info("request json is " + dest);
        cacheManageService.getCache(null, username);

        logger.info("request " + paramMap);
        Object resp = cacheManageService.getCache(paramMap,username);
        logger.info("resp " + resp);

        resp = cacheManageService.getCache(null, username);
        logger.info("resp1 " + resp);
    }
}
