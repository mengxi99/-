package com.kunpeng.entity;

/**
 * 木木
 */
public class Dep {
    private int deptid;
    private String deptname;

    public Dep() {
    }

    @Override
    public String toString() {
        return "Dep{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                '}';
    }

    public Dep(int deptid, String deptname) {
        this.deptid = deptid;
        this.deptname = deptname;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
