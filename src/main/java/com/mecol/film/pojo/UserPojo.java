package com.mecol.film.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class UserPojo implements Serializable {
    private Integer userId;
    private String userName;
    private String userEmli;
    private String userPhone;
    private String userMoney;

    public String getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(String userMoney) {
        this.userMoney = userMoney;
    }

    private Integer sex;
    private MultipartFile file;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmli() {
        return userEmli;
    }

    public void setUserEmli(String userEmli) {
        this.userEmli = userEmli;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
