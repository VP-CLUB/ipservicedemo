package cn.vpclub.storage.mapper;


import cn.vpclub.api.domain.AppInfo;
import cn.vpclub.api.domain.BaseAppInfo;
import cn.vpclub.api.model.request.AppInfoParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated
     */
    int insert(BaseAppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated
     */
    int insertSelective(BaseAppInfo record);

    /**
     * 根据应用系统ID查询应用系统基础信息
     *
     * @param id 应用系统ID
     * @return BaseAppInfo
     */
    BaseAppInfo findBaseAppInfoById(String id);

    /**
     * 根据应用系统ID查询应用系统信息
     *
     * @param id 应用系统ID
     * @return AppInfo
     */
    AppInfo findAppInfoById(String id);

    /**
     * 根据应用系统编号(appId)查询应用系统基础信息
     *
     * @param appId 应用系统编号(appId)
     * @return BaseAppInfo
     */
    BaseAppInfo findBaseAppInfoByAppId(Long appId);

    /**
     * 根据应用系统编号(appId)查询应用系统信息
     *
     * @param appId 应用系统编号(appId)
     * @return AppInfo
     */
    AppInfo findAppInfoByAppId(Long appId);

    /**
     * 根据条件参数对象信息查询应用系统基础信息列表
     *
     * @param pageParam 条件参数对象信息
     * @return List<BaseAppInfo>
     */
    List<BaseAppInfo> findBaseAppInfoByParam(@Param("pageParam") AppInfoParam pageParam);

    /**
     * 根据条件参数对象信息查询应用系统基础信息列表
     *
     * @param pageParam 条件参数对象信息
     * @return List<BaseAppInfo>
     */
    Integer findDataTotalByParam(@Param("pageParam") AppInfoParam pageParam);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BaseAppInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BaseAppInfo record);
}