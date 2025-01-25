package com.mecol.film.pojo;

import com.mecol.film.entity.Play;
import com.mecol.film.entity.Seat;
import com.mecol.film.entity.Users;

import java.io.Serializable;

public class TicA implements Serializable {
    private Integer ticketId;
    private Integer playId;
    private Integer userId;
    private Integer seatId;
    private String buyingTime;

    public TicA() {
        super();
    }

    @Override
    public String toString() {
        return "TicA{" +
                "ticketId=" + ticketId +
                ", playId=" + playId +
                ", userId=" + userId +
                ", seatId=" + seatId +
                ", buyingTime='" + buyingTime + '\'' +
                '}';
    }

    public TicA(Integer ticketId, Integer playId, Integer userId, Integer seatId, String buyingTime) {
        this.ticketId = ticketId;
        this.playId = playId;
        this.userId = userId;
        this.seatId = seatId;
        this.buyingTime = buyingTime;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
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

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(String buyingTime) {
        this.buyingTime = buyingTime;
    }
}
