package cn.vpclub.api.model.response;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 接口返回基类
 *
 * Created by admin on 2016/3/10.
 */
@MappedSuperclass
public class BaseResponse<T> implements Serializable {
    /**
     * 请求结果
     */
    protected Integer returnCode;

    /**
     * 错误信息
     */
    protected String message;

    /**
     * 操作数据信息(请求结果成功返回)
     */
    protected T dataInfo;

    /**
     * Default Constructor
     */
    public BaseResponse() {
        super();
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

    public T getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(T dataInfo) {
        this.dataInfo = dataInfo;
    }
}
