package com.mecol.film.pojo;

import java.io.Serializable;

public class ScreenwriterFilm implements Serializable {
    private Integer id;
    private Integer filmId;
    private Integer ScreenwriterId;

    public ScreenwriterFilm() {
        super();
    }

    public ScreenwriterFilm(Integer id, Integer filmId, Integer screenwriterId) {
        this.id = id;
        this.filmId = filmId;
        ScreenwriterId = screenwriterId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getScreenwriterId() {
        return ScreenwriterId;
    }

    public void setScreenwriterId(Integer screenwriterId) {
        ScreenwriterId = screenwriterId;
    }

    @Override
    public String toString() {
        return "ScreenwriterFilm{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", ScreenwriterId=" + ScreenwriterId +
                '}';
    }
}
