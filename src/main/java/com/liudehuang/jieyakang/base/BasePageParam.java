package com.liudehuang.jieyakang.base;


import javax.validation.constraints.NotNull;

/**
 * @author liudehuang
 * @date 2019/5/15 10:29
 */
public class BasePageParam {
    /**
     * 第几页
     */
    @NotNull(message = "pageNo页码不能为空")
    private Integer pageNo;
    /**
     * 一页多少行
     */
    @NotNull(message = "pageSize行数不能为空")
    private Integer pageSize;

    public Integer getPageNo() {
        return pageSize*(pageNo-1);
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
