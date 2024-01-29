package com.kunpeng.entity;

import java.util.List;

/**
 * 木木
 */
public class PageModel {
    private int pageCount;
    private List<Emp> empList;
    private int currentPage;

    public PageModel() {
    }

    public PageModel(int pageCount, List<Emp> empList, int currentPage) {
        this.pageCount = pageCount;
        this.empList = empList;
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "pageCount=" + pageCount +
                ", empList=" + empList +
                ", currentPage=" + currentPage +
                '}';
    }
}
