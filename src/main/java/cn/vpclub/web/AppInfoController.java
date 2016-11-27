package cn.vpclub.web;

import cn.vpclub.api.AppInfoService;
import cn.vpclub.api.CacheManageService;
import cn.vpclub.api.domain.AppInfo;
import cn.vpclub.api.domain.BaseAppInfo;
import cn.vpclub.api.model.request.AppInfoParam;
import cn.vpclub.api.model.response.BaseResponse;
import cn.vpclub.api.model.response.PageDataResponse;
import cn.vpclub.common.enums.ReturnCodeEnum;
import cn.vpclub.common.utils.HttpResponseUtil;
import cn.vpclub.common.utils.JsonUtil;
import cn.vpclub.common.utils.MapParserUtil;
import cn.vpclub.common.utils.StringUtil;
import cn.vpclub.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/3/29.
 */
@RestController
@RequestMapping("/common/appInfo")
public class AppInfoController extends BaseController {
    private int counter;
    @Value("${ipservice.message}")
    private String message;
    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private CacheManageService cacheManageService;

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public String ipaddress() throws Exception {
        return message+ "---"+InetAddress.getLocalHost().getHostAddress()+"--"+(++counter);
    }
    /**
     * save cache
     *
     * @param reqMap
     * @param resp
     */
    @RequestMapping(value = "saveCache", method = RequestMethod.POST)
    public void saveCache(@RequestBody Map<String, String> reqMap, @Context HttpServletResponse resp) {
        BaseResponse response = new BaseResponse();
        try {
            String requestJson =  JsonUtil.objectToJson(reqMap);
            logger.info("saveCache method request: " +requestJson);
            Object data = cacheManageService.putCache(requestJson,reqMap.get("cacheKey"));
            response.setDataInfo(data);
            response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        }
        catch (Exception e){
            response.setReturnCode(ReturnCodeEnum.CODE_1005.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1005.getValue());
        }
        String responseStr = JsonUtil.objectToJson(response);

        logger.info("saveCache method return data: " + responseStr);
        // 设置接口返回信息
        HttpResponseUtil.setResponseBody(resp, responseStr);
    }
    /**
     * get cache
     *
     * @param reqMap
     * @param resp
     */
    @RequestMapping(value = "getCache", method = RequestMethod.POST)
    public void getCache(@RequestBody Map<String, String> reqMap, @Context HttpServletResponse resp) {
        BaseResponse response = new BaseResponse();
        try {
            String requestJson =  JsonUtil.objectToJson(reqMap);
            logger.info("getCache method request: " +requestJson);
            Object data = cacheManageService.getCache(null,reqMap.get("cacheKey"));
            response.setDataInfo(data);
            response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        }
        catch (Exception e){
            response.setReturnCode(ReturnCodeEnum.CODE_1005.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1005.getValue());
        }
        String responseStr = JsonUtil.objectToJson(response);

        logger.info("getCache method return data: " + responseStr);
        // 设置接口返回信息
        HttpResponseUtil.setResponseBody(resp, responseStr);
    }

    /**
     * 查询外部应用系统信息列表
     *
     * @param param
     * @param resp
     */
    @RequestMapping(value = "findDataPage", method = RequestMethod.POST)
    public void findDataPage(@RequestBody AppInfoParam param, @Context HttpServletResponse resp) {
        logger.info("findDataPage method request: " + JsonUtil.objectToJson(param));
        if (null == param) {
            param = new AppInfoParam(1, 10);
        }
        // 查询数据
        PageDataResponse<BaseAppInfo> pageDataResponse = appInfoService.findDataPage(param);

        String responseStr = JsonUtil.objectToJson(pageDataResponse);
        logger.info("findDataPage method return data: " + responseStr);
        // 设置接口返回信息
        HttpResponseUtil.setResponseBody(resp, responseStr);
    }

    /**
     * 查询外部应用系统信息列表
     *
     * @param reqMap
     * @param resp
     */
    @RequestMapping(value = "findAllDataList", method = RequestMethod.POST)
    public void findAllDataList(@RequestBody Map<String, Object> reqMap, @Context HttpServletResponse resp) {
        logger.info("findAllDataList method request: " + JsonUtil.objectToJson(reqMap));
        String appName = null;
        if (null != reqMap && !reqMap.isEmpty()) {
            appName = MapParserUtil.getStringFromMap(reqMap, "appName");
        }
        // 查询数据
        List<BaseAppInfo> pageDataResponse = appInfoService.findDataList(appName);

        String responseStr = JsonUtil.objectToJson(pageDataResponse);
        logger.info("findAllDataList method return data: " + responseStr);
        // 设置接口返回信息
        HttpResponseUtil.setResponseBody(resp, responseStr);
    }

    /**
     * 根据主键ID查询外部应用系统信息
     *
     * @param reqMap
     * @param resp
     */
    @RequestMapping(value = "findDataInfo", method = RequestMethod.POST)
    public void findDataInfo(@RequestBody Map<String, Object> reqMap, @Context HttpServletResponse resp) {
        logger.info("findDataInfo method request: " + JsonUtil.objectToJson(reqMap));
        AppInfo dataInfo = null;
        String dataId = null;
        if (null != reqMap && !reqMap.isEmpty()) {
            dataId = MapParserUtil.getStringFromMap(reqMap, "dataId");
        }
        if (StringUtil.isNotEmpty(dataId)) {
            // 查询数据
            dataInfo = appInfoService.findDataInfoById(dataId);
        }

        String responseStr = null;
        if (null != dataInfo) {
            responseStr = JsonUtil.objectToJson(dataInfo);
        } else {
            responseStr = "{}";
        }
        logger.info("findDataInfo method return data: " + responseStr);
        // 设置接口返回信息
        HttpResponseUtil.setResponseBody(resp, responseStr);
    }
}
