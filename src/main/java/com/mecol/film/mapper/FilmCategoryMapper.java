package com.mecol.film.mapper;

import com.mecol.film.entity.Film;
import com.mecol.film.entity.FilmCategory;
import com.mecol.film.pojo.FilmAndType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmCategoryMapper {

    FilmCategory type(Integer id);

    List<FilmCategory> list(FilmCategory filmCategory);

    int update(FilmCategory filmCategory);

    int add(FilmCategory filmCategory);

    int addType(FilmAndType filmAndType);

    FilmAndType typeById(FilmAndType filmAndType);

    int typeByUp(FilmAndType filmAndType);
}
