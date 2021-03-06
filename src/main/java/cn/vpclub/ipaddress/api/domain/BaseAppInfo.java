package cn.vpclub.ipaddress.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用系统信息
 *
 * Created by HJ on 2016/3/29.
 */
public class BaseAppInfo implements Serializable {
    /**
     * 唯一标识(应用系统id)
     */
    private String id;

    /**
     * 应用系统编号(appId)
     */
    private Long appId;

    /**
     * 父应用系统编号
     */
    private Long parentAppId;

    /**
     * 应用系统名称
     */
    private String appName;

    /**
     * 应用系统私钥
     */
    private String appSecretKey;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 删除标记(0:正常; 1:删除; 2:审核)
     */
    private Integer delFlag = 0;

    /**
     * 备注说明
     */
    private String remarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.id
     *
     * @return the value of app_info.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.id
     *
     * @param id the value for app_info.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.app_id
     *
     * @return the value of app_info.app_id
     *
     * @mbggenerated
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.app_id
     *
     * @param appId the value for app_info.app_id
     *
     * @mbggenerated
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.parent_app_id
     *
     * @return the value of app_info.parent_app_id
     *
     * @mbggenerated
     */
    public Long getParentAppId() {
        return parentAppId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.parent_app_id
     *
     * @param parentAppId the value for app_info.parent_app_id
     *
     * @mbggenerated
     */
    public void setParentAppId(Long parentAppId) {
        this.parentAppId = parentAppId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.app_name
     *
     * @return the value of app_info.app_name
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.app_name
     *
     * @param appName the value for app_info.app_name
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.app_secret_key
     *
     * @return the value of app_info.app_secret_key
     *
     * @mbggenerated
     */
    public String getAppSecretKey() {
        return appSecretKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.app_secret_key
     *
     * @param appSecretKey the value for app_info.app_secret_key
     *
     * @mbggenerated
     */
    public void setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey == null ? null : appSecretKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.create_by
     *
     * @return the value of app_info.create_by
     *
     * @mbggenerated
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.create_by
     *
     * @param createBy the value for app_info.create_by
     *
     * @mbggenerated
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.create_date
     *
     * @return the value of app_info.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.create_date
     *
     * @param createDate the value for app_info.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.update_by
     *
     * @return the value of app_info.update_by
     *
     * @mbggenerated
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.update_by
     *
     * @param updateBy the value for app_info.update_by
     *
     * @mbggenerated
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.update_date
     *
     * @return the value of app_info.update_date
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.update_date
     *
     * @param updateDate the value for app_info.update_date
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.del_flag
     *
     * @return the value of app_info.del_flag
     *
     * @mbggenerated
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.del_flag
     *
     * @param delFlag the value for app_info.del_flag
     *
     * @mbggenerated
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_info.remarks
     *
     * @return the value of app_info.remarks
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_info.remarks
     *
     * @param remarks the value for app_info.remarks
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}