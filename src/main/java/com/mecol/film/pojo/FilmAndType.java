package com.mecol.film.pojo;

import java.io.Serializable;

public class FilmAndType implements Serializable {
    private Integer typeId;
    private Integer categoryId;
    private Integer filmId;

    public Integer getTypeId() {
        return typeId;
    }

    public FilmAndType(Integer typeId, Integer categoryId, Integer filmId) {
        this.typeId = typeId;
        this.categoryId = categoryId;
        this.filmId = filmId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }
}
