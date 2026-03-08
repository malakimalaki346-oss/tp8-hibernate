package com.example.service;

import com.example.model.Reservation;
import java.util.List;

public interface ReservationService {

    void create(Reservation reservation);

    Reservation findById(Long id);

    List<Reservation> findAll();

    void update(Reservation reservation);

    void delete(Reservation reservation);

}