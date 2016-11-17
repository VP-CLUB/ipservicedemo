package cn.vpclub.api.model.request;

import javax.persistence.MappedSuperclass;

/**
 * 分页查询基础参数类
 *
 * @author HJ
 */
@MappedSuperclass
public class PageBaseSearchParam extends BasePageParam {

    /**
     * 页码
     */
    protected Integer pageNumber;

    public PageBaseSearchParam() {
        super();
    }

    public PageBaseSearchParam(Integer pageSize, Integer pageNumber) {
        super();
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.startRow = (null == pageNumber || 0 == pageNumber ? 0
                : (pageNumber - 1)) * (null == pageSize ? 10 : pageSize);
    }

    /**
     * GET页码
     *
     * @return Integer
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * SET页码
     *
     * @param pageNumber
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * GET查询开始记录行号
     *
     * @return Integer
     */
    @Override
    public Integer getStartRow() {
        return startRow = (null == this.getPageNumber() || 0 == this.getPageNumber() ? 0
                : (this.getPageNumber() - 1)) * (null == this.getPageSize() ? 10 : this.getPageSize());
    }

    /**
     * SET查询开始记录行号
     *
     * @param startRow
     */
    @Override
    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
