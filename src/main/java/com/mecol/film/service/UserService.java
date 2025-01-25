package com.mecol.film.service;

import com.mecol.film.entity.Users;
import com.mecol.film.mapper.UserMapper;
import com.mecol.film.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


public interface UserService {
    /**
     * 用户登录
     * @param users
     * @return
     */
    Users login(Users users, HttpServletRequest request);
    Users upLogin(Users users, HttpServletRequest request);
    /**
     * 用户修改信息
     * @param users
     * @return
     */
    int update(UserPojo users,HttpServletRequest request);

    /**
     * 添加用户
     * @param users
     * @return
     */
    int add(Users users);


    /**
     * 用户充值
     * @param users
     * @return
     */
    int updateMoney(UserPojo users,HttpServletRequest request);

}
