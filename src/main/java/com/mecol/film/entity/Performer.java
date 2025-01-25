package com.mecol.film.entity;

import java.io.Serializable;

public class Performer implements Serializable {
    private Integer performerId;
    private String performerName;

    public Performer() {
        super();
    }

    public Performer(Integer performerId, String performerName) {
        this.performerId = performerId;
        this.performerName = performerName;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "performerId=" + performerId +
                ", performerName='" + performerName + '\'' +
                '}';
    }

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }
}
