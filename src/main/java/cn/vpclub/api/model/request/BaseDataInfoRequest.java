package cn.vpclub.api.model.request;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 接口操作数据信息对象基类
 *
 * Created by admin on 2016/6/6.
 */
@MappedSuperclass
public class BaseDataInfoRequest<T> implements Serializable {

    /**
     * token
     */
    protected String token;

    /**
     * 操作数据信息
     */
    protected T dataInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(T dataInfo) {
        this.dataInfo = dataInfo;
    }
}
