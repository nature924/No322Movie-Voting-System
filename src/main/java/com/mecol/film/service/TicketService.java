package com.mecol.film.service;

import com.mecol.film.entity.Ticket;
import com.mecol.film.entity.Users;
import com.mecol.film.pojo.Tic;

import java.util.List;
import java.util.Map;

public interface TicketService {
    List<Ticket> playById(Integer id);

    int add(Tic tic, Users user);

    Map userList(Integer pageNum,Integer id);

    Map getAllUserList(Integer page);

    Integer deleteById(Integer ticketId);
}
