package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * @param <T>
 */
public class PageTool<T> {

    private Integer currentPageNo = 1;//当前页码

    private Integer pageSize = 5;//每页显示数量

    private Integer totalCount = 1;//总记录数

    private Integer pageTotalCount = 1;//总页数

    private List<T> list = new ArrayList<T>();//分页集合

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        if(totalCount > 0){

            this.totalCount = totalCount;
            this.pageTotalCount = this.totalCount%this.pageSize == 0 ? this.totalCount/this.pageSize :this.totalCount/this.pageSize+1;
        }

    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
