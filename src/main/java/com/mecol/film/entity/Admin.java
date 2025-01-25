package com.mecol.film.entity;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer adminId;
    private String adminName;
    private String account;
    private String adminPwd;
    private String imgUrl;
    private String createTime;
    private String updateTime;
    private Integer isDelete;

    public Admin() {
        super();
    }

    public Admin(Integer adminId, String adminName, String account, String adminPwd, String imgUrl, String createTime, String updateTime, Integer isDelete) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.account = account;
        this.adminPwd = adminPwd;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
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

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", account='" + account + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
