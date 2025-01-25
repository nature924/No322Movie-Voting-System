package com.mecol.film.pojo;

import com.mecol.film.entity.Play;
import com.mecol.film.entity.Seat;
import com.mecol.film.entity.Users;

import java.io.Serializable;
import java.util.List;

public class Tic implements Serializable {
    private Integer playId;
    private Integer userId;
    private Integer sun;
    private String seat;
    private String money;

    public String getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Tic{" +
                "playId=" + playId +
                ", userId=" + userId +
                ", sun=" + sun +
                ", seat='" + seat + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Tic() {
        super();
    }

    public Tic(Integer playId, Integer userId, Integer sun, String seat,String money) {
        this.playId = playId;
        this.userId = userId;
        this.sun = sun;
        this.seat = seat;
        this.money = money;
    }

    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSun() {
        return sun;
    }

    public void setSun(Integer sun) {
        this.sun = sun;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

}
