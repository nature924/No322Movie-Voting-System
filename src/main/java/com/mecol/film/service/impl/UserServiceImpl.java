package com.mecol.film.service.impl;

import com.mecol.film.entity.Users;
import com.mecol.film.ip.LoginIp;
import com.mecol.film.mapper.UserMapper;
import com.mecol.film.pojo.UserPojo;
import com.mecol.film.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Users login(Users users, HttpServletRequest request){
        String pwd= null;
        try {
            pwd = DigestUtils.md5Hex(users.getUserPassword().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(pwd);
        users.setUserPassword(pwd);
        Users user=userMapper.login(users);
        if (user!=null){
            String a= LoginIp.getIpAddress(request);
            Users u=new Users();
            u.setUserId(user.getUserId());
            u.setLastIp(a);
            int b=userMapper.update(u);
        }
        return user;
    }

    public Users upLogin(Users users, HttpServletRequest request) {
        return userMapper.login(users);
    }

    public int update(UserPojo pojo,HttpServletRequest request) {
        Users users=new Users();
        if (pojo.getFile()!=null){
            //获取当前路径真实盘符
            String path=request.getServletContext().getRealPath("/")+"img/";
            System.out.println(request.getServletContext().getRealPath("/")+"img/");
            //获取当前上传文件的文件名
            String fileName=pojo.getFile().getOriginalFilename();
            System.out.println(pojo.getFile().getOriginalFilename());
            //设置上传文件放在服务器中的全路径名称（例如 ：C：/tomcat/webapp/upload/***.jpg）
            File f=new File(path+fileName);
            //判断是否存在该文件夹,不存在就创建
            if (!f.exists()){
                f.mkdirs();
            }
            //上传文件
            try {
                pojo.getFile().transferTo(f);
                String url="/img/"+fileName;
                users.setImgUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        users.setUserName(pojo.getUserName());
        users.setUserId(pojo.getUserId());
        users.setUserEmli(pojo.getUserEmli());
        users.setUserPhone(pojo.getUserPhone());
        users.setSex(pojo.getSex());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String time=df.format(date);
        users.setUpdateTime(time);

        return userMapper.update(users);
    }

    public int add(Users users) {
        String pwd= null;
        try {
            pwd = DigestUtils.md5Hex(users.getUserPassword().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(pwd);
        users.setUserPassword(pwd);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String time=df.format(date);
        users.setUpdateTime(time);
        users.setCreateTime(time);
        return userMapper.add(users);
    }

    @Override
    public int updateMoney(UserPojo pojo, HttpServletRequest request) {
        Users users=new Users();
        users.setUserId(pojo.getUserId());
        // users.setUserMoney(pojo.getUserMoney());
        Users userQuery = userMapper.userById(pojo.getUserId());
        String moneyOld = (String) userQuery.getUserMoney();
        String moneyNew = (String) pojo.getUserMoney();
        if(moneyOld!=null && !"".equals(moneyOld)){
            if(moneyNew!=null && !"".equals(moneyNew)){
                int money = Integer.valueOf(moneyOld)+Integer.valueOf(moneyNew);
                users.setUserMoney(String.valueOf(money));
            }else{
                users.setUserMoney(moneyOld);
            }
        }else {
            users.setUserMoney("0");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String time=df.format(date);
        users.setUpdateTime(time);

        return userMapper.update(users);
    }
}
