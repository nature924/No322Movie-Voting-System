package com.mecol.film.entity;

import java.io.Serializable;

public class FilmCategory implements Serializable {
    private Integer categoryId;
    private String filmCategory;
    private Integer isDelete;

    public FilmCategory() {
        super();
    }

    public FilmCategory(Integer categoryId, String filmCategory, Integer isDelete) {
        this.categoryId = categoryId;
        this.filmCategory = filmCategory;
        this.isDelete = isDelete;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(String filmCategory) {
        this.filmCategory = filmCategory;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "categoryId=" + categoryId +
                ", filmCategory='" + filmCategory + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
