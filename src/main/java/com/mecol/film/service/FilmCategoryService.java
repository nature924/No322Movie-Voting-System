package com.mecol.film.service;

import com.mecol.film.entity.FilmCategory;

import java.util.List;
import java.util.Map;

public interface FilmCategoryService {
    FilmCategory type(Integer id);

    Map list(Integer pageNum, FilmCategory filmCategory);

    List<FilmCategory> all();

    int update(FilmCategory filmCategory);

    int add(FilmCategory filmCategory);
}
