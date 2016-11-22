package cn.vpclub.service.impl;

import cn.vpclub.api.AppInfoService;
import cn.vpclub.api.domain.AppConfig;
import cn.vpclub.api.domain.AppInfo;
import cn.vpclub.api.domain.BaseAppInfo;
import cn.vpclub.api.model.request.AppInfoParam;
import cn.vpclub.api.model.response.BaseResponse;
import cn.vpclub.api.model.response.PageDataResponse;
import cn.vpclub.common.enums.ReturnCodeEnum;
import cn.vpclub.common.utils.JsonUtil;
import cn.vpclub.common.utils.SqlParamUtil;
import cn.vpclub.common.utils.StringUtil;
import cn.vpclub.storage.mapper.AppConfigMapper;
import cn.vpclub.storage.mapper.AppInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 外部应用系统信息业务数据操作服务接口实现类
 * <p>
 * Created by HJ on 2016/3/29.
 */
@Service(value = "appInfoServiceImpl")
@Transactional
public class AppInfoServiceImpl implements AppInfoService {
    private static Logger logger = LoggerFactory.getLogger(AppInfoServiceImpl.class);
    private AppInfoMapper appInfoMapper;
    private AppConfigMapper appConfigMapper;

    @Autowired
    public AppInfoServiceImpl(AppInfoMapper appInfoMapper,
                              AppConfigMapper appConfigMapper
                              ) {
        this.appInfoMapper = appInfoMapper;
        this.appConfigMapper = appConfigMapper;
    }



    /**
     * 根据主键ID删除外部应用系统信息
     *
     * @param key 主键ID
     * @return BaseResponse
     */
    public BaseResponse deleteDataInfoByKey(String key) {
        logger.info("deleteDataInfoByKey method param data: " + key);
        BaseResponse response = new BaseResponse();
        if (StringUtil.isNotEmpty(key)) {
            appConfigMapper.deleteByAppInfoId(key);
            appInfoMapper.deleteByPrimaryKey(key);
            // 成功删除数据
            response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        } else {
            response.setReturnCode(ReturnCodeEnum.CODE_1006.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1006.getValue());
        }
        return response;
    }

    /**
     * 查询外部应用系统信息列表
     *
     * @param param 条件参数对象信息
     * @return PageDataResponse
     */
    public cn.vpclub.api.model.response.PageDataResponse findDataPage(AppInfoParam param) {
        logger.info("findDataPage method param data: " + JsonUtil.objectToJson(param));
        PageDataResponse<BaseAppInfo> pageDataResponse = new PageDataResponse<BaseAppInfo>();
        if (null != param) {
            // 处理参数
            if (StringUtil.isNotEmpty(param.getAppName())) {
                param.setAppName(SqlParamUtil.convertLikeParam(param.getAppName()));
            }
            // 查询数据
            List<BaseAppInfo> dataList = appInfoMapper.findBaseAppInfoByParam(param);

            Integer dataTotal = 0;
            if (null != dataList && !dataList.isEmpty()) {
                dataTotal = appInfoMapper.findDataTotalByParam(param);
            }
            pageDataResponse.setPageData(dataList);
            pageDataResponse.setTotalRecord(dataTotal);
            pageDataResponse.setPageNumber(param.getPageNo());
            pageDataResponse.setPageSize(param.getPageSize());
            pageDataResponse.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
            pageDataResponse.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        } else {
            pageDataResponse.setReturnCode(ReturnCodeEnum.CODE_1005.getCode());
            pageDataResponse.setMessage(ReturnCodeEnum.CODE_1005.getValue());
        }
        return pageDataResponse;
    }

    /**
     * 查询外部应用系统信息列表
     *
     * @param appName 外部应用系统名称
     * @return PageDataResponse
     */
    public List<BaseAppInfo> findDataList(String appName) {
        // 查询数据
        AppInfoParam param = new AppInfoParam();
        if (StringUtil.isNotEmpty(appName)) {
            param.setAppName(SqlParamUtil.convertLikeParam(appName));
        }
        List<BaseAppInfo> dataList = appInfoMapper.findBaseAppInfoByParam(param);
        return dataList;
    }

    /**
     * 根据应用系统ID查询应用系统信息
     *
     * @param key 应用系统ID
     * @return AppInfo
     */
    public AppInfo findDataInfoById(String key) {
        logger.info("findDataInfoById method param data: " + key);
        AppInfo dataInfo = null;
        if (StringUtil.isNotEmpty(key)) {
            dataInfo = appInfoMapper.findAppInfoById(key);
        }
        return dataInfo;
    }

    /**
     * 根据应用系统编号(appId)查询应用系统信息
     *
     * @param appId 系统编号(appId)
     * @return AppInfo
     */
    public AppInfo findDataInfoByAppId(Long appId) {
        logger.info("findDataInfoByAppId method param data: " + appId);
        AppInfo dataInfo = null;
        if (null != appId && !"".equals(appId)) {
            dataInfo = appInfoMapper.findAppInfoByAppId(appId);
        }
        return dataInfo;
    }

    /**
     * 根据应用系统编号(appId)与接口服务类型查询应用系统接口配置信息
     *
     * @param appId 外部应用系统appKey(appId)
     * @param type  接口服务类型
     * @return AppConfig
     */
    public AppConfig findAppConfigByAppIdAndType(Long appId, Integer type) {
        logger.info("findAppConfigByAppIdAndType method param data: " + appId + "," + type);
        AppConfig appConfigInfo = null;
        if (null != appId && null != type) {
            appConfigInfo = appConfigMapper.findByAppIdAndType(appId, type);
        }
        return appConfigInfo;
    }
}
