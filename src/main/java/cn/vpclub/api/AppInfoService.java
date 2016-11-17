package cn.vpclub.api;


import cn.vpclub.api.domain.AppInfo;
import cn.vpclub.api.domain.BaseAppInfo;
import cn.vpclub.api.model.request.AppInfoParam;
import cn.vpclub.api.model.response.BaseResponse;
import cn.vpclub.api.model.response.PageDataResponse;

import java.util.List;

/**
 * 应用系统信息业务数据操作服务接口类
 * <p>
 * Created by HJ on 2016/3/29.
 */
public interface AppInfoService {
    /**
     * 保存应用系统信息
     *
     * @param dataInfo
     * @return BaseResponse
     */
    public default BaseResponse<AppInfo> saveDataInfo(AppInfo dataInfo) {
        return null;
    }

    /**
     * 根据应用系统ID删除应用系统信息
     *
     * @param key 应用系统ID
     * @return BaseResponse
     */
    public BaseResponse deleteDataInfoByKey(String key);

    /**
     * 查询应用系统信息列表
     *
     * @param param 条件参数对象信息
     * @return PageDataResponse
     */
    public PageDataResponse findDataPage(AppInfoParam param);

    /**
     * 查询应用系统信息列表
     *
     * @param appName  应用系统名称
     * @return PageDataResponse
     */
    public List<BaseAppInfo> findDataList(String appName);

    /**
     * 根据应用系统ID查询应用系统信息
     *
     * @param key 应用系统ID
     * @return BaseAppInfo
     */
    public AppInfo findDataInfoById(String key);

    /**
     * 根据应用系统编号(appId)查询应用系统信息
     *
     * @param appId 应用系统编号(appId)
     * @return BaseAppInfo
     */
    public AppInfo findDataInfoByAppId(Long appId);


}
