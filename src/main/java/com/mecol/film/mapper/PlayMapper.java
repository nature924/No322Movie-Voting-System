package com.mecol.film.mapper;

import com.mecol.film.entity.Play;
import com.mecol.film.pojo.PlayPojo;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayMapper {
    /**
     * 根据电影id查询排期
     * @param id
     * @return
     */
    List<Play> filmById(Integer id);

    /**
     * 根据排期单个查询
     * @param id
     * @return
     */
    Play playById(Integer id);

    List<Play> list();

    Integer update(Play play);

    List<Play> delist();

    Integer add(PlayPojo play);
}
