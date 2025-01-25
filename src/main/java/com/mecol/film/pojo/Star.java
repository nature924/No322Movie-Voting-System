package com.mecol.film.pojo;

import java.io.Serializable;

public class Star implements Serializable {
    private Integer starId;
    private Integer filmId;
    private Integer performerId;

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }

    @Override
    public String toString() {
        return "Star{" +
                "starId=" + starId +
                ", filmId=" + filmId +
                ", performerId=" + performerId +
                '}';
    }
}
