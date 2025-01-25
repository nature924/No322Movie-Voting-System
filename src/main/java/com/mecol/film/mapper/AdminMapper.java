package com.mecol.film.mapper;

import com.mecol.film.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminMapper {

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);
    List<Admin> list();
    /**
     * 修改
     * @param admin
     * @return
     */
    int update(Admin admin);
}
