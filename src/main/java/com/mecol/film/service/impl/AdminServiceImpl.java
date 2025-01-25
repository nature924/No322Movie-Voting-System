package com.mecol.film.service.impl;

import com.mecol.film.entity.Admin;
import com.mecol.film.ip.LoginIp;
import com.mecol.film.mapper.AdminMapper;
import com.mecol.film.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admin login(Admin admin) throws UnsupportedEncodingException {
        String a=admin.getAdminPwd();
        String pwd= DigestUtils.md5Hex(a.getBytes("utf-8"));
        admin.setAdminPwd(pwd);
        return adminMapper.login(admin);
    }
}
