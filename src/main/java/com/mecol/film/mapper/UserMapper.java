package com.mecol.film.mapper;

import com.mecol.film.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 用户登录
     * @param users
     * @return
     */
     Users login(Users users);

     Users userById(Integer id);
    /**
     * 用户修改信息
     * @param users
     * @return
     */
     int update(Users users);

    /**
     * 添加用户
     * @param users
     * @return
     */
     int add(Users users);

}
