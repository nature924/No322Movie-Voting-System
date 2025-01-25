package com.mecol.film.mapper;

import com.mecol.film.entity.Film;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmMapper {
    /**
     * 查询全部
     * @return
     */
    List<Film> list();

    /**
     * 查电影
     * @return
     */
    List<Film> listF();
    /**
     * 单个查询
     * @param filmId
     * @return
     */
    Film film(Integer filmId);

    /**
     * 修改电影
     * @param film
     * @return
     */
    int update(Film film);

    int up(Integer id);

    int delete(Integer id);

    List<Film> isDelete();
    /**
     * 添加电影
     * @param film
     * @return
     */
    int add(Film film);

    Integer filmByName(String filmName);

    List<Film> mohu(String name);
}
