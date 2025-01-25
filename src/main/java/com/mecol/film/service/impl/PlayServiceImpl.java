package com.mecol.film.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.film.entity.Film;
import com.mecol.film.entity.Play;
import com.mecol.film.mapper.PlayMapper;
import com.mecol.film.pojo.PlayPojo;
import com.mecol.film.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class PlayServiceImpl implements PlayService {
    @Autowired
    private PlayMapper playMapper;
    public List<Play> filmById(Integer id) {
        return playMapper.filmById(id);
    }
    public Play playById(Integer id) {
        return playMapper.playById(id);
    }

    public Map list(Integer page) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(page,5);
        List<Play> list=playMapper.list();
        PageInfo<Play> info=new PageInfo<Play>(list);
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

    public Map delist(Integer page) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(page,5);
        List<Play> list=playMapper.delist();
        PageInfo<Play> info=new PageInfo<Play>(list);
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

    public Integer update(Play play) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String time=df.format(date);
        play.setUpdateTime(time);
        return playMapper.update(play);
    }

    public Integer add(PlayPojo play) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String time=df.format(date);
        play.setUpdateTime(time);
        play.setCreateTime(time);
        return playMapper.add(play);
    }
}
