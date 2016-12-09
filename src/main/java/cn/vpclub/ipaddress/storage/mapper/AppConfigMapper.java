package cn.vpclub.ipaddress.storage.mapper;

import cn.vpclub.ipaddress.api.domain.AppConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AppConfigMapper {

    /**
     * 根据主键删除应用系统接口配置信息
     *
     * @param appInfoId   应用系统信息ID
     * @param serviceType 接口类型
     * @return int
     */
    int deleteByPrimaryKey(@Param("appInfoId") String appInfoId,
                           @Param("serviceType") Integer serviceType);

    /**
     * 根据应用系统信息ID删除应用系统接口配置信息
     *
     * @param appInfoId 应用系统信息ID
     * @return int
     */
    int deleteByAppInfoId(@Param("appInfoId") String appInfoId);

    /**
     * 根据应用系统编号(appId)删除应用系统接口配置信息
     *
     * @param appId 应用系统编号(appId)
     * @return int
     */
    int deleteByAppId(@Param("appId") Long appId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_config
     *
     * @mbggenerated
     */
    int insert(AppConfig record);

    /**
     * 批量新增应用系统接口配置信息
     *
     * @param recordList 应用系统接口配置信息
     * @return int
     */
    int batchInsert(List<AppConfig> recordList);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_config
     *
     * @mbggenerated
     */
    int insertSelective(AppConfig record);

    /**
     * 根据主键查询应用系统接口配置信息
     *
     * @param appInfoId   应用系统信息ID
     * @param serviceType 接口类型
     * @return AppConfig
     */
    AppConfig selectByPrimaryKey(@Param("appInfoId") String appInfoId,
                                 @Param("serviceType") Integer serviceType);

    /**
     * 根据应用系统编号(appId)与接口服务类型查询应用系统接口配置信息
     *
     * @param appId       应用系统编号(appId)
     * @param serviceType 接口类型
     * @return AppConfig
     */
    AppConfig findByAppIdAndType(@Param("appId") Long appId,
                                 @Param("serviceType") Integer serviceType);

    /**
     * 根据应用系统信息ID查询应用系统接口配置信息
     *
     * @param appInfoId 应用系统信息ID
     * @return AppConfig
     */
    AppConfig selectByAppInfoId(@Param("appInfoId") String appInfoId);

    /**
     * 根据应用系统编号(appId)查询应用系统接口配置信息
     *
     * @param appId 应用系统编号(appId)
     * @return AppConfig
     */
    AppConfig selectByAppId(@Param("appId") Long appId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_config
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AppConfig record);
}