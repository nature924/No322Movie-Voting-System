package com.mecol.film.controller;

import com.alibaba.fastjson.JSON;
import com.mecol.film.entity.Film;
import com.mecol.film.entity.Play;
import com.mecol.film.entity.Ticket;
import com.mecol.film.entity.Users;
import com.mecol.film.mapper.TestDao;
import com.mecol.film.pojo.Tic;
import com.mecol.film.pojo.UserPojo;
import com.mecol.film.service.FilmService;
import com.mecol.film.service.PlayService;
import com.mecol.film.service.TicketService;
import com.mecol.film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReceptionController {

    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private PlayService playService;
    @Autowired
    private TicketService ticketService;

    //首页 8080/film 打开电影首页
    @RequestMapping("/")
    public String index(@ModelAttribute Users user, HttpServletRequest request, Model model){
        HttpSession session=request.getSession();
        user= (Users) session.getAttribute("user");
        Map<String,Object> map =filmService.list(1,8);
        model.addAttribute("map",map);
       /// System.out.println(user);
        if (user!=null){
            model.addAttribute("user",user);
        }
        /*
        else {
            Users u = new Users();
            u.setUserName("1");
            model.addAttribute("userb", u);
        }*/
        return "user/home";
    }


    @RequestMapping("/list")
    public ModelAndView List(){
        ModelAndView modelAndView=new ModelAndView("user/listfilm");
        //每页显示8部电影
        Map<String,Object> map= filmService.list(1,8);
        modelAndView.addObject("map",map);
        return modelAndView;
    }

    @RequestMapping("/filmlist")
    public ModelAndView filmList(Integer page){
        ModelAndView modelAndView=new ModelAndView("user/listfilm");
        //从第page开始 再选出8个 如果有的话
        Map<String,Object> map= filmService.list(page,8);
        modelAndView.addObject("map",map);
        return modelAndView;
    }
    //电影详情
    @RequestMapping("/filma")
    public String film(Integer filmId,Users user,HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        user= (Users) session.getAttribute("user");
        model.addAttribute("user",user);
        Film film=filmService.film(filmId);
        model.addAttribute("film",film);
      //  System.out.println(film);
        return "user/film";

    }


    /**
     * 购票界面

     */
    @RequestMapping("/goupiao")
    public String goupiao(Integer filmId,Users user,
                          HttpServletRequest request,
                          Model model){
        HttpSession session=request.getSession();
        user= (Users) session.getAttribute("user");
        model.addAttribute("user",user);
        List<Play> list=playService.filmById(filmId);

        if (list.size()!=0) {
            model.addAttribute("list", list);
            Play play = playService.playById(list.get(0).getPlayId());
            // System.out.println("a"+play);
            model.addAttribute("play", play);
            return "user/goupiao";
        }
        else {
            Film film=filmService.film(filmId);
            model.addAttribute("film",film);
            return "user/noPlay"; //没有档期 没有排档期
        }
    }


    /**
     * 跟换排期

     */
    @RequestMapping("/goupiao2")
    public String goupiao2(Integer playId,Users user,HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        user= (Users) session.getAttribute("user");
        model.addAttribute("user",user);
        Play play=playService.playById(playId);
        model.addAttribute("play",play);
        List<Play> list=playService.filmById(play.getFilm().getFilmId());
        model.addAttribute("list",list);
        model.addAttribute("index",playId);
        return "user/goupiao";
    }


    /**
     * 登录
    */

    @RequestMapping("/login")
    @ResponseBody
    public Users login(Users users, HttpServletRequest request){
        Users user= null;
        user = userService.login(users,request);
      //  System.out.println(user);
        if (user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
          //  System.out.println(session.getAttribute("user"));
            return user;
        }else{
            Users users1=new Users();
            users1.setUserId(0); //创造一个假的 说明数据库中没有这个 前端用
            return users1;
        }
    }

    /**
     * 用户退出

     */
    @RequestMapping("/tui")
    @ResponseBody
    public String tui(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        return "";
    }


    /**
     * 购买电影票

     */
    @RequestMapping(value = "/goumai",method = RequestMethod.POST)
    @ResponseBody
    public Integer goumai(Tic tic, HttpServletRequest request){
        HttpSession session=request.getSession();
        Users user= (Users) session.getAttribute("user");
        tic.setUserId(user.getUserId());
       // System.out.println(tic);
        int a=ticketService.add(tic,user);
        return a;
    }


    /**
     * 影城介绍
     */
    @RequestMapping("/we")
    public String we(@ModelAttribute Users user, HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        user= (Users) session.getAttribute("user");
        System.out.println(user);
        if (user!=null){
            model.addAttribute("user",user);
        }else {
            Users u = new Users();
            u.setUserName("1");
            model.addAttribute("userb", u);
        }
        return "user/jies";
    }

    @RequestMapping("/mohu")
    public String mohu(String name,Integer page,Model model){
        Map map=filmService.mohu(name,page);
        model.addAttribute("map",map);
        return "user/listfilm";
    }


    @RequestMapping("/personal")
    public String personal(Integer page,HttpServletRequest request,Model model){
        Users users=new Users();
        HttpSession session=request.getSession();
        users= (Users) session.getAttribute("user");
        //System.out.println(users);
        if (page==null){
            page=1;
        }
        if (users!=null){
            /*修改完后时实更新*/
            Map<String,Object> map=ticketService.userList(page,users.getUserId());
            model.addAttribute("map",map);
            /*model.addAttribute("user",users);*/
            Users u=userService.upLogin(users,request);
            session.setAttribute("user",u);
            model.addAttribute("user",session.getAttribute("user"));
        }else{
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("pages",0);
            map.put("pageNum",0);
            model.addAttribute("map",map);
        }
        return "user/personal";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(UserPojo userPojo, HttpServletRequest request){
        Users users=new Users();
        HttpSession session=request.getSession();
        users= (Users) session.getAttribute("user");
        userPojo.setUserId(users.getUserId());
        userService.update(userPojo,request);
        return "redirect:/personal";
    }

    @RequestMapping(value = "/updateMoney",method = RequestMethod.POST)
    public String updateMoney(UserPojo userPojo, HttpServletRequest request){
        Users users=new Users();
        HttpSession session=request.getSession();
        users= (Users) session.getAttribute("user");
        userPojo.setUserId(users.getUserId());
        userService.updateMoney(userPojo,request);
        return "redirect:/personal";
    }


    /**
     *已被购买的
     */
    @RequestMapping("/mai")
    @ResponseBody
    public String mai(Integer playId, Users user){
       // System.out.println(playId);
        List<Ticket> list=ticketService.playById(playId);
       // System.out.println(list);
        /* model.addAttribute("ticket",list);*/
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("ticket",list);
        String a= JSON.toJSONString(map);
        return a;
    }

    @RequestMapping("/zhu")
    @ResponseBody
    public Integer zhu(Users users){
        return userService.add(users);
    }


}
