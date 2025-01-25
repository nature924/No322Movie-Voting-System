package com.mecol.film.service.impl;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.mecol.film.entity.Film;
import com.mecol.film.entity.FilmCategory;
import com.mecol.film.entity.Performer;
import com.mecol.film.entity.Screenwriter;
import com.mecol.film.mapper.FilmCategoryMapper;
import com.mecol.film.mapper.FilmMapper;
import com.mecol.film.mapper.PerformerMapper;
import com.mecol.film.mapper.ScreenwriterMapper;
import com.mecol.film.pojo.FilmAndType;
import com.mecol.film.pojo.FilmPojo;
import com.mecol.film.pojo.ScreenwriterFilm;
import com.mecol.film.pojo.Star;
import com.mecol.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private PerformerMapper performerMapper;
    @Autowired
    private ScreenwriterMapper screenwriterMapper;
    @Autowired
    private FilmCategoryMapper filmCategoryMapper;
    public Map list(Integer pageNum,Integer pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(pageNum,pageSize);
        List<Film> list=filmMapper.list();
        PageInfo<Film> info=new PageInfo<Film>(list);
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

    public List<Film> listF() {
        return filmMapper.listF();
    }

    public Film film(Integer filmId) {
        return filmMapper.film(filmId);
    }

    public int add(FilmPojo film, HttpServletRequest request) {
        Film filmadd=new Film();
        filmadd.setFilmName(film.getFilmName());
        filmadd.setFilmTime(film.getFilmTime());
        filmadd.setDirector(film.getDirector());
        filmadd.setPlayTime(film.getPlayTime());

        //获取当前路径真实盘符
        String path=request.getServletContext().getRealPath("/")+"img/";
        System.out.println(request.getServletContext().getRealPath("/")+"img/");
        //获取当前上传文件的文件名
        String fileName=film.getFile().getOriginalFilename();
        System.out.println(film.getFile().getOriginalFilename());
        //设置上传文件放在服务器中的全路径名称（例如 ：C：/tomcat/webapp/upload/***.jpg）
        File f=new File(path+fileName);
        //判断是否存在该文件夹,不存在就创建
        if (!f.exists()){
            f.mkdirs();
        }
        //上传文件
        try {
            film.getFile().transferTo(f);
            String url="/img/"+fileName;
            filmadd.setPosterUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Star star=new Star();
        ScreenwriterFilm screenwriterFilm=new ScreenwriterFilm();
        List<Performer> list=performerMapper.list(new Performer(null,film.getStar()));
        List<Screenwriter> list1=screenwriterMapper.list(new Screenwriter(null,film.getScreenwriters()));
        System.out.println(list.size()==0);
        if (list.size()==0){
            performerMapper.add(new Performer(null,film.getStar()));
            star.setPerformerId(performerMapper.list(new Performer(null,film.getStar())).get(0).getPerformerId());
        }else{
            star.setPerformerId(list.get(0).getPerformerId());
        }
        if (list1.size()==0){
            screenwriterMapper.add(new Screenwriter(null,film.getScreenwriters()));
            screenwriterFilm.setScreenwriterId(screenwriterMapper.list(new Screenwriter(null,film.getScreenwriters())).get(0).getScreenwriterId());
        }else{
            screenwriterFilm.setScreenwriterId(list1.get(0).getScreenwriterId());
        }
        int a=0;
        a+=filmMapper.add(filmadd);
        Integer id=filmMapper.filmByName(film.getFilmName());
        star.setFilmId(id);
        screenwriterFilm.setFilmId(id);
        a+=performerMapper.starAdd(star);
        a+=screenwriterMapper.ScreenwriterFilmAdd(screenwriterFilm);
        a+=filmCategoryMapper.addType(new FilmAndType(null,film.getCategoryId(),id));
        return a;
    }

    public int delete(Integer id) {
        return filmMapper.delete(id);
    }

    public int up(Integer id) {
        return filmMapper.up(id);
    }

    public Map isDelete(Integer pageNum, Integer pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(pageNum,pageSize);
        List<Film> list=filmMapper.isDelete();
        /*System.out.println(list.get(1));*/
        PageInfo<Film> info=new PageInfo<Film>(list);
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

    public Map mohu(String name, Integer pageNum) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(pageNum,8);
        List<Film> list=filmMapper.mohu(name);
        PageInfo<Film> info=new PageInfo<Film>(list);
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


    public int update(Film film) {
        return 0;
    }

}
