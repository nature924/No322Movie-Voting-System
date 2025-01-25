package com.mecol.film.entity;

import java.io.Serializable;

public class Ticket implements Serializable {
    private Integer ticketId;
    private Play play;
    private Users user;
    private Seat seat;
    private String buyingTime;

    public Ticket() {
        super();
    }

    public Ticket(Integer ticketId, Play play, Users user, Seat seat, String buyingTime) {
        this.ticketId = ticketId;
        this.play = play;
        this.user = user;
        this.seat = seat;
        this.buyingTime = buyingTime;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(String buyingTime) {
        this.buyingTime = buyingTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", play=" + play +
                ", user=" + user +
                ", seat=" + seat +
                ", buyingTime='" + buyingTime + '\'' +
                '}';
    }
}
