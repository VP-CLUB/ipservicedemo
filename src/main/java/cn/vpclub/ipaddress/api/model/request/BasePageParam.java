package cn.vpclub.ipaddress.api.model.request;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 分页查询基础参数类
 *
 * @author HJ
 */
@MappedSuperclass
public abstract class BasePageParam implements Serializable {
    /**
     * 每页查询记录数
     */
    protected Integer pageSize;

    /**
     * 查询开始记录行号
     */
    protected Integer startRow;

    public BasePageParam() {
        super();
    }

    /**
     * GET每页查询记录数
     *
     * @return Integer
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * SET每页查询记录数
     *
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * GET查询开始记录行号
     *
     * @return Integer
     */
    public abstract Integer getStartRow();

    /**
     * SET查询开始记录行号
     *
     * @param startRow
     */
    public abstract void setStartRow(Integer startRow);
}
