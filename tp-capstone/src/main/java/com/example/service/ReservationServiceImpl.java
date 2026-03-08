package com.example.service;

import com.example.model.Reservation;
import com.example.repository.ReservationRepository;
import com.example.repository.ReservationRepositoryImpl;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository repository = new ReservationRepositoryImpl();

    @Override
    public void create(Reservation reservation) {
        repository.create(reservation);
    }

    @Override
    public Reservation findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Reservation reservation) {
        repository.update(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        repository.delete(reservation);
    }
}