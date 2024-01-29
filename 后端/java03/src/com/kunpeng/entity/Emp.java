package com.kunpeng.entity;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * 木木
 */
@JSONType(orders = {"id","name","gender","birth","level","mobile"})
public class Emp {
    private int id;
    private String name;
    private String gender;
    private String birth;
    private String level;
    private String mobile;

    public Emp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", level='" + level + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Emp(int id, String name, String gender, String birth, String level, String mobile) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.level = level;
        this.mobile = mobile;
    }
}
