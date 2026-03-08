package com.example.util;

import com.example.model.*;
import com.example.service.ReservationService;
import com.example.service.ReservationServiceImpl;
import com.example.service.SalleService;
import com.example.service.SalleServiceImpl;

import java.time.LocalDateTime;

public class DataInitialiser {

    public static void initData() {

        SalleService salleService = new SalleServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl();

        // Création salles
        Salle s1 = new Salle("Salle Informatique", 30, "Bloc A");
        Salle s2 = new Salle("Salle Réunion", 15, "Bloc B");

        salleService.create(s1);
        salleService.create(s2);

        // Création utilisateur
        Utilisateur u1 = new Utilisateur(
                "Dupont",
                "Jean",
                "jean.dupont@mail.com",
                "0600000000",
                "IT"
        );

        // Création réservation
        Reservation r1 = new Reservation();
        r1.setSalle(s1);
        r1.setUtilisateur(u1);
        r1.setDateDebut(LocalDateTime.now().plusDays(1));
        r1.setDateFin(LocalDateTime.now().plusDays(1).plusHours(2));
        r1.setStatut(StatutReservation.CONFIRMEE);

        reservationService.create(r1);

        System.out.println("Données initialisées !");
    }
}