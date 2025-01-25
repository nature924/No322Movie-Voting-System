package com.mecol.film.mapper;

import com.mecol.film.entity.Seat;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatMapper {
    Seat seatById(Integer id);

    Seat seatBySeat(String seat);
}
