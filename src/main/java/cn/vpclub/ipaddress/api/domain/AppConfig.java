package cn.vpclub.ipaddress.api.domain;

import java.io.Serializable;

/**
 * 应用系统接口配置信息
 * <p>
 * Created by HJ on 2016/6/6.
 */
public class AppConfig implements Serializable {

    /**
     * 应用系统信息ID
     */
    private String appInfoId;

    /**
     * 应用系统编号(appId)
     */
    private Long appId;

    /**
     * 接口类型(0:用户; 1:用户授权; 2:物料; 3:短信; 4;快递; 5:支付)
     */
    private Integer serviceType;

    /**
     * 接口服务访问URL
     */
    private String callUrl;

    /**
     * 接口服务回调URL
     */
    private String callbackUrl;

    /**
     * 备注说明
     */
    private String remarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_config.app_info_id
     *
     * @return the value of app_config.app_info_id
     *
     * @mbggenerated
     */
    public String getAppInfoId() {
        return appInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_config.app_info_id
     *
     * @param appInfoId the value for app_config.app_info_id
     *
     * @mbggenerated
     */
    public void setAppInfoId(String appInfoId) {
        this.appInfoId = appInfoId == null ? null : appInfoId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_config.app_id
     *
     * @return the value of app_config.app_id
     *
     * @mbggenerated
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_config.app_id
     *
     * @param appId the value for app_config.app_id
     *
     * @mbggenerated
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_config.service_type
     *
     * @return the value of app_config.service_type
     *
     * @mbggenerated
     */
    public Integer getServiceType() {
        return serviceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_config.service_type
     *
     * @param serviceType the value for app_config.service_type
     *
     * @mbggenerated
     */
    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_config.call_url
     *
     * @return the value of app_config.call_url
     *
     * @mbggenerated
     */
    public String getCallUrl() {
        return callUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_config.call_url
     *
     * @param callUrl the value for app_config.call_url
     *
     * @mbggenerated
     */
    public void setCallUrl(String callUrl) {
        this.callUrl = callUrl == null ? null : callUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_config.callback_url
     *
     * @return the value of app_config.callback_url
     *
     * @mbggenerated
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_config.callback_url
     *
     * @param callbackUrl the value for app_config.callback_url
     *
     * @mbggenerated
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_config.remarks
     *
     * @return the value of app_config.remarks
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_config.remarks
     *
     * @param remarks the value for app_config.remarks
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}