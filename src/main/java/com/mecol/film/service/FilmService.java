package com.mecol.film.service;

import com.mecol.film.entity.Film;
import com.mecol.film.pojo.FilmPojo;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface FilmService {
    /**
     * 查询全部
     * @return
     */
    Map<String,Object> list(Integer pageNum,Integer pageSize);
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

    /**
     * 添加电影
     * @param film
     * @return
     */
    int add(FilmPojo film, HttpServletRequest request);

    int delete(Integer id);

    int up(Integer id);

    Map isDelete(Integer pageNum,Integer pageSize);

    Map mohu(String name,Integer pageNum);

}
