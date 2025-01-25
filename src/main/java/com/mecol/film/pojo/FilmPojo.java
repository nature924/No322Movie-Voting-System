package com.mecol.film.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class FilmPojo implements Serializable {
    private Integer id;
    private String filmName;
    private Integer categoryId;
    private String director;
    private String screenwriters;
    private String star;
    private String filmTime;
    private String playTime;
    private MultipartFile file;

    public FilmPojo() {
        super();
    }



    public Integer getId() {
        return id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriters() {
        return screenwriters;
    }

    public void setScreenwriters(String screenwriters) {
        this.screenwriters = screenwriters;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(String filmTime) {
        this.filmTime = filmTime;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "FilmPojo{" +
                "id=" + id +
                ", filmName='" + filmName + '\'' +
                ", categoryId=" + categoryId +
                ", director='" + director + '\'' +
                ", screenwriters='" + screenwriters + '\'' +
                ", star='" + star + '\'' +
                ", filmTime='" + filmTime + '\'' +
                ", playTime='" + playTime + '\'' +
                ", file=" + file +
                '}';
    }
}
