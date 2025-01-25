package com.mecol.film.entity;

import java.io.Serializable;

public class Seat implements Serializable {
    private Integer seatId;
    private String seat;

    public Seat() {
        super();
    }

    public Seat(Integer seatId, String seat) {
        this.seatId = seatId;
        this.seat = seat;
    }


    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seat='" + seat + '\'' +
                '}';
    }
}
