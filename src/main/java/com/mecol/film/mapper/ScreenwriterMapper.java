package com.mecol.film.mapper;

import com.mecol.film.entity.Screenwriter;
import com.mecol.film.pojo.ScreenwriterFilm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenwriterMapper {

    Screenwriter scr(Integer id);

    List<Screenwriter> list(Screenwriter screenwriter);

    int add(Screenwriter screenwriter);

    ScreenwriterFilm ScreenwriterFilmById(ScreenwriterFilm screenwriterFilm);

    int ScreenwriterFilmByUp(ScreenwriterFilm screenwriterFilm);

    int ScreenwriterFilmAdd(ScreenwriterFilm screenwriterFilm);

}
