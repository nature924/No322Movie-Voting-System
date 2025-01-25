package com.mecol.film.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.film.entity.Film;
import com.mecol.film.entity.FilmCategory;
import com.mecol.film.mapper.FilmCategoryMapper;
import com.mecol.film.service.FilmCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FilmCategoryServiceImpl implements FilmCategoryService {

    @Autowired
    private FilmCategoryMapper filmCategoryMapper;
    public FilmCategory type(Integer id) {
        return filmCategoryMapper.type(id);
    }
    
    public Map list(Integer pageNum,FilmCategory filmCategory) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(pageNum,5);
        List<FilmCategory> list=filmCategoryMapper.list(filmCategory);
        /*System.out.println(list.get(1));*/
        PageInfo<FilmCategory> info=new PageInfo<FilmCategory>(list);
        //总记录
        map.put("conut",info.getTotal());


        //是否有上一页
        map.put("prevopus",info.isHasPreviousPage());
        //是否有下一页
        map.put("next",info.isHasNextPage());
        //总页数
        map.put("pages",info.getPages());
        //当前页码
        map.put("pageNum",info.getPageNum());
        //查到的数组
        map.put("info",info.getList());
        return map;
    }

    public List<FilmCategory> all() {
        return filmCategoryMapper.list(null);
    }

    public int  update(FilmCategory filmCategory) {
        return filmCategoryMapper.update(filmCategory);
    }


    public int add(FilmCategory filmCategory) {
        return filmCategoryMapper.add(filmCategory);
    }
}
