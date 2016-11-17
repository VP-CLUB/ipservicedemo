package cn.vpclub.api.model.response;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.List;

/**
 * 分页返回基类
 *
 * Created by admin on 2016/3/9.
 */
@MappedSuperclass
public class PageDataResponse<T> implements Serializable {
    /**
     * 每页查询记录数
     */
    protected Integer pageSize;

    /**
     * 页码
     */
    protected Integer pageNumber;

    /**
     * 总记录数
     */
    protected Integer totalRecord = 0;

    /**
     * 请求结果
     */
    protected Integer returnCode = 1000;

    /**
     * 错误信息
     */
    protected String message;

    /**
     * 操作数据信息(请求结果成功返回)
     */
    protected List<T> pageData;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
