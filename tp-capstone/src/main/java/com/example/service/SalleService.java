package com.example.service;

import com.example.model.Salle;
import java.util.List;

public interface SalleService {

    void create(Salle salle);

    Salle findById(Long id);

    List<Salle> findAll();

    void update(Salle salle);

    void delete(Salle salle);

}