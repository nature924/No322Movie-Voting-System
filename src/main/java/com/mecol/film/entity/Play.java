package com.mecol.film.entity;

import java.io.Serializable;

public class Play implements Serializable {
    private Integer playId;
    private String playTime;
    private Film film;
    private Room room;
    private Double money;
    private String createTime;
    private String updateTime;
    private Integer isDelete;

    public Play() {
        super();
    }

    public Play(Integer playId) {
        this.playId = playId;
    }

    public Play(Integer playId, String playTime, Film film, Room room, Double money, String createTime, String updateTime, Integer isDelete) {
        this.playId = playId;
        this.playTime = playTime;
        this.film = film;
        this.room = room;
        this.money = money;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Play{" +
                "playId=" + playId +
                ", playTime='" + playTime + '\'' +
                ", film=" + film +
                ", room=" + room +
                ", money=" + money +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
