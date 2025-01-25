package com.mecol.film.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.film.entity.*;
import com.mecol.film.mapper.PlayMapper;
import com.mecol.film.mapper.SeatMapper;
import com.mecol.film.mapper.TicketMapper;
import com.mecol.film.mapper.UserMapper;
import com.mecol.film.pojo.Tic;
import com.mecol.film.pojo.TicA;
import com.mecol.film.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class TicketServiceImpl implements TicketService {
    @Resource
    private TicketMapper ticketMapper;
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PlayMapper playMapper;
    public List<Ticket> playById(Integer id) {
        return ticketMapper.playById(id);
    }

    public int add(Tic tic,Users user) {
        int a=0;

        String moneySum =  tic.getMoney();
        if(moneySum!=null && !"".equals(moneySum)){
            Users userQuery = userMapper.userById(user.getUserId());
            String moneyOld = userQuery.getUserMoney();
            if(moneyOld!=null && !"".equals(moneyOld)){
                int moneyInt = Integer.valueOf(moneyOld)-Integer.valueOf(moneySum);
                if(moneyInt<0){
                    a = -1;
                }else{
                    String moneySting = String.valueOf(moneyInt);
                    user.setUserMoney(moneySting);
                    if(userMapper.update(user)<0){
                        a = -2;
                    }
                }
            }else{
                a = -1;
            }
        }

        if(a==0){
            char x[]=tic.getSeat().toCharArray();
            List<String> y =new ArrayList<String>();
            for (int i=0;i<tic.getSeat().length();){
                String b=x[i]+""+x[i+1]+""+x[i+2];
                y.add(b);
                i+=3;
            }
            for (int i=0;i<tic.getSun();i++) {
                if (userMapper.userById(tic.getUserId())!=null){
                    if (seatMapper.seatBySeat(y.get(i))!=null){
                        if (playMapper.playById(tic.getPlayId())!=null){
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date=new Date();
                            String time=df.format(date);
                            TicA ticA=new TicA();
                            ticA.setPlayId(tic.getPlayId());
                            ticA.setSeatId(seatMapper.seatBySeat(y.get(i)).getSeatId());
                            ticA.setUserId(tic.getUserId());
                            ticA.setBuyingTime(time);
                            a+= ticketMapper.add(ticA);
                        }
                    };
                }
            }
        }

        return a;
    }

    public Map userList(Integer pageNum,Integer id) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(pageNum,8);
        List<Ticket> list= ticketMapper.userList(id);
        PageInfo<Ticket> info=new PageInfo<Ticket>(list);
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

    @Override
    public Map getAllUserList(Integer page) {
        Map<String,Object> map=new HashMap<String,Object>();
        PageHelper.startPage(page,8);
        List<Ticket> list= ticketMapper.getAllUserList();
        PageInfo<Ticket> info=new PageInfo<Ticket>(list);
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

    @Override
    public Integer deleteById(Integer ticketId) {
        return ticketMapper.deleteById(ticketId);
    }


}
