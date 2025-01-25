package com.mecol.film.service;

import com.mecol.film.entity.Admin;

import java.io.UnsupportedEncodingException;

public interface AdminService {
    /**
     * 管理员登录
     * @param admin
     * @return
     */
    Admin login(Admin admin) throws UnsupportedEncodingException;
}
