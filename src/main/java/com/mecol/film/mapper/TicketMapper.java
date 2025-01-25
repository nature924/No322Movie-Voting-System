package com.mecol.film.mapper;

import com.mecol.film.entity.Ticket;
import com.mecol.film.pojo.TicA;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketMapper {

    List<Ticket> playById(Integer id);

    int add(TicA ticA);

    List<Ticket> userList(Integer id);

    List<Ticket> getAllUserList();

    Integer deleteById(Integer ticketId);
}
