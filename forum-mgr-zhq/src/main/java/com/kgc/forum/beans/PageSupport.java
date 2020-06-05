package com.kgc.forum.beans;

public class PageSupport {
    // 总条数
    private int totalCount;

    // 当前页码
    private int currentPageNo;

    // 页面容量
    private int pageSize;

    // 总的页数
    private int totalPage;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        // 在设置总条数的同时及时总的页数
        if(totalCount > 0){
            this.totalCount = totalCount;
            // 总条数确定了，总页数也就确定了
            if(this.totalCount % this.pageSize == 0){
                this.setTotalPage(this.totalCount / this.pageSize);
            } else {
                this.setTotalPage(this.totalCount / this.pageSize + 1);
            }
        }
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


}
