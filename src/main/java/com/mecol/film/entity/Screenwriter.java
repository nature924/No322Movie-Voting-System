package com.mecol.film.entity;

import java.io.Serializable;

public class Screenwriter implements Serializable {
    private Integer screenwriterId;
    private String screenwriterName;

    public Screenwriter() {
        super();
    }

    public Screenwriter(Integer screenwriterId, String screenwriterName) {
        this.screenwriterId = screenwriterId;
        this.screenwriterName = screenwriterName;
    }

    @Override
    public String toString() {
        return "Screenwriter{" +
                "screenwriterId=" + screenwriterId +
                ", screenwriterName='" + screenwriterName + '\'' +
                '}';
    }

    public Integer getScreenwriterId() {
        return screenwriterId;
    }

    public void setScreenwriterId(Integer screenwriterId) {
        this.screenwriterId = screenwriterId;
    }

    public String getScreenwriterName() {
        return screenwriterName;
    }

    public void setScreenwriterName(String screenwriterName) {
        this.screenwriterName = screenwriterName;
    }
}
