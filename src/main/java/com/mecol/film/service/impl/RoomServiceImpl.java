package com.mecol.film.service.impl;

import com.mecol.film.entity.Room;
import com.mecol.film.mapper.RoomMapper;
import com.mecol.film.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    public List<Room> list() {
        return roomMapper.list();
    }
}
