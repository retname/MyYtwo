package cn.zy.empty;

import java.util.List;

/**
 * Created by zhangyu on 2017/6/16.
 */
public class page {


    private int pageIndex;   //当前页

    private int pageAll;     //总页数

    private  int allCount;   //总数据量

    private int pageSize;    //每页数据量

    private List<emple> getAll;  //集合


    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageAll(int pageAll) {
        this.pageAll = pageAll;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setGetAll(List<emple> getAll) {
        this.getAll = getAll;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getPageAll() {
        return pageAll;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<emple> getGetAll() {
        return getAll;
    }





}
