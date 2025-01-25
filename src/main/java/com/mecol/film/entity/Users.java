package com.mecol.film.entity;

import java.io.Serializable;

public class Users implements Serializable {
    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Integer sex;
    private String userEmli;
    private String userPhone;
    private String imgUrl;
    private String userMoney;
    private String createTime;
    private String updateTime;
    private String lastIp;
    private Integer isDelete;

    public Users() {
        super();
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userName, String userAccount, String userPassword, Integer sex, String userEmli, String userPhone, String imgUrl, String createTime, String updateTime, String lastIp, Integer isDelete) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.sex = sex;
        this.userEmli = userEmli;
        this.userPhone = userPhone;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastIp = lastIp;
        this.isDelete = isDelete;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String userAccount() {
        return userAccount;
    }

    public void userAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmli() {
        return userEmli;
    }

    public void setUserEmli(String userEmli) {
        this.userEmli = userEmli;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getUserMoney() { return userMoney; }

    public void setUserMoney(String userMoney) { this.userMoney = userMoney; }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", sex=" + sex +
                ", userEmli='" + userEmli + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", userMoney='" + userMoney + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

}
