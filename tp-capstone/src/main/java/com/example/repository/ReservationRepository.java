package com.example.repository;

import com.example.model.Reservation;
import java.util.List;

public interface ReservationRepository {

    void create(Reservation reservation);

    Reservation findById(Long id);

    List<Reservation> findAll();

    void update(Reservation reservation);

    void delete(Reservation reservation);

}