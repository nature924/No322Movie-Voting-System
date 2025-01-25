package com.mecol.film.controller;


import com.mecol.film.entity.Admin;
import com.mecol.film.entity.FilmCategory;
import com.mecol.film.entity.Play;
import com.mecol.film.entity.Ticket;
import com.mecol.film.pojo.DeleteAndUp;
import com.mecol.film.pojo.FilmPojo;
import com.mecol.film.pojo.PlayPojo;
import com.mecol.film.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/root")
public class AdminController {

    @Autowired
    private FilmCategoryService filmCategoryService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private PlayService playService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private TicketService ticketService;


    //输入/root/admin 打开后台登陆首页



    @RequestMapping("/admin")
    public String admin(Model model, HttpServletRequest request){
        HttpSession session=request.getSession();
        Admin admin= (Admin) session.getAttribute("admin");
        model.addAttribute("admin",admin);
        return "admin/admin/admin";
    }
    @RequestMapping("/tuichu")
    @ResponseBody
    public String tui(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("admin");
        return "admin/login";
    }

    @RequestMapping("/home")
    public String home(){
        return "admin/admin/home";
    }

    @RequestMapping("/type")
    public String type(Integer page, Model model){
        model.addAttribute("type",filmCategoryService.list(page,null));
        return "admin/admin/type";
    }
    @RequestMapping(value = "/typedelete",method = RequestMethod.POST)
    @ResponseBody
    public Integer typedelete(FilmCategory filmCategory){
        filmCategory.setIsDelete(0);
        return filmCategoryService.update(filmCategory);
    }
    @RequestMapping("/isfilm")
    public String isfilm(Integer page,Model model){
        model.addAttribute("map",filmService.list(page,5));
        model.addAttribute("type",filmCategoryService.all());
        model.addAttribute("is",1);
        return "admin/admin/isfilm";
    }

    /**
     * 添加类型
     * @param filmCategory
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Integer add(FilmCategory filmCategory){
        return filmCategoryService.add(filmCategory);
    }

    @RequestMapping("/typeupdate")
    @ResponseBody
    public Integer typeupdate(FilmCategory filmCategory){
        return filmCategoryService.update(filmCategory);
    }

    @RequestMapping("/addfilm")
    @ResponseBody
    public Integer addfilm(FilmPojo filmPojo, HttpServletRequest request){
        System.out.println(filmPojo);
        return filmService.add(filmPojo,request);
    }

    @RequestMapping("/xiajia")
    @ResponseBody
    public Integer xiajia(DeleteAndUp deleteAndUp){
        if (deleteAndUp.getMode().equals("下架")){
            return filmService.delete(deleteAndUp.getId());
        }else if (deleteAndUp.getMode().equals("上架")){
            return filmService.up(deleteAndUp.getId());
        }
        return 0;
    }

    @RequestMapping("/isdelete")
    public String isdelete(Integer page,Model model){
        model.addAttribute("map",filmService.isDelete(page,5));
        model.addAttribute("type",filmCategoryService.all());
        model.addAttribute("is",0);
        return "admin/admin/isfilm";
    }

    @RequestMapping("/room")
    public String room(Integer page,Model model){
        if (page==null){
            page=1;
        }
        model.addAttribute("is",1);
        model.addAttribute("film",filmService.listF());
        model.addAttribute("room",roomService.list());
        Map map=playService.list(page);
        model.addAttribute("map",map);
        return "admin/admin/room";
    }
    @RequestMapping("/deroom")
    public String deroom(Integer page,Model model){
        if (page==null){
            page=1;
        }
        model.addAttribute("is",0);
        model.addAttribute("film",filmService.listF());
        model.addAttribute("room",roomService.list());
        Map map=playService.delist(page);
        model.addAttribute("map",map);
        return "admin/admin/room";
    }

    @RequestMapping("/ticket")
    public String ticket(Integer page,Model model){
        if (page==null){
        page=1;
        }

        Map<String,Object> map=ticketService.getAllUserList(page);
        model.addAttribute("map",map);
        return "admin/admin/allTickets";
    }





    @RequestMapping("/ticketDel")
    @ResponseBody
    public Integer ticketDel(Ticket ticket){

      //  System.out.println(ticket.getTicketId());
        return ticketService.deleteById(ticket.getTicketId());
    }





    @RequestMapping("/play")
    @ResponseBody
    public Integer play(DeleteAndUp deleteAndUp){
        Play play=new Play();
        if (deleteAndUp.getMode().equals("下档")){
            play.setPlayId(deleteAndUp.getId());
            play.setIsDelete(0);
        }else if (deleteAndUp.getMode().equals("上映")){
            play.setPlayId(deleteAndUp.getId());
            play.setIsDelete(1);
        }
        return  playService.update(play);
    }
    @RequestMapping("/playAdd")
    @ResponseBody
    public Integer playAdd(PlayPojo play){
        System.out.println(play);
        return playService.add(play);
    }




}
