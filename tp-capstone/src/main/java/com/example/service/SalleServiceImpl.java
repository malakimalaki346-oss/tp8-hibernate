package com.example.service;

import com.example.model.Salle;
import com.example.repository.SalleRepository;
import com.example.repository.SalleRepositoryImpl;

import java.util.List;

public class SalleServiceImpl implements SalleService {

    private SalleRepository repository = new SalleRepositoryImpl();

    @Override
    public void create(Salle salle) {
        repository.create(salle);
    }

    @Override
    public Salle findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Salle> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Salle salle) {
        repository.update(salle);
    }

    @Override
    public void delete(Salle salle) {
        repository.delete(salle);
    }
}