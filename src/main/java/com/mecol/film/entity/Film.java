package com.mecol.film.entity;

import java.io.Serializable;
import java.util.List;

public class Film implements Serializable {
    private Integer filmId;
    private String filmName;
    private String filmTime;
    private String director;
    private String playTime;
    private String posterUrl;
    private FilmCategory filmCategory;
    private Performer star;
    private Screenwriter screenwriters;
    private Integer isDelete;

    public Film() {
        super();
    }

    public Film(Integer filmId, String filmName, String filmTime, String director, String playTime, String posterUrl, FilmCategory filmCategory, Performer star, Screenwriter screenwriters, Integer isDelete) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmTime = filmTime;
        this.director = director;
        this.playTime = playTime;
        this.posterUrl = posterUrl;
        this.filmCategory = filmCategory;
        this.star = star;
        this.screenwriters = screenwriters;
        this.isDelete = isDelete;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(String filmTime) {
        this.filmTime = filmTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public FilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(FilmCategory filmCategory) {
        this.filmCategory = filmCategory;
    }

    public Performer getStar() {
        return star;
    }

    public void setStar(Performer star) {
        this.star = star;
    }

    public Screenwriter getScreenwriters() {
        return screenwriters;
    }

    public void setScreenwriters(Screenwriter screenwriters) {
        this.screenwriters = screenwriters;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", filmTime='" + filmTime + '\'' +
                ", director='" + director + '\'' +
                ", playTime='" + playTime + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", filmCategory=" + filmCategory +
                ", star=" + star +
                ", screenwriters=" + screenwriters +
                ", isDelete=" + isDelete +
                '}';
    }
}
