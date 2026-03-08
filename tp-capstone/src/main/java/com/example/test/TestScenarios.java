package com.example.test;

import com.example.model.*;
import com.example.service.ReservationService;
import com.example.service.ReservationServiceImpl;
import com.example.service.SalleService;
import com.example.service.SalleServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class TestScenarios {

    private static final SalleService salleService = new SalleServiceImpl();
    private static final ReservationService reservationService = new ReservationServiceImpl();

    public static void runAllTests() {

        System.out.println("===== TEST SCENARIOS =====");

        scenario1_creerSalle();
        scenario2_afficherSalles();
        scenario3_creerReservation();
        scenario4_afficherReservations();
        scenario5_annulerReservation();
    }

    // SCENARIO 1 : créer une salle
    public static void scenario1_creerSalle() {

        System.out.println("\n--- Scenario 1 : Création d'une salle ---");

        Salle salle = new Salle();
        salle.setNom("Salle Réunion A");
        salle.setCapacite(20);
        salle.setLocalisation("Bloc A");

        salleService.create(salle);

        System.out.println("Salle créée avec succès !");
    }

    // SCENARIO 2 : afficher toutes les salles
    public static void scenario2_afficherSalles() {

        System.out.println("\n--- Scenario 2 : Liste des salles ---");

        List<Salle> salles = salleService.findAll();

        for (Salle s : salles) {
            System.out.println(s);
        }
    }

    // SCENARIO 3 : créer une réservation
    public static void scenario3_creerReservation() {

        System.out.println("\n--- Scenario 3 : Création d'une réservation ---");

        Salle salle = salleService.findById(1L);

        Utilisateur utilisateur = new Utilisateur(
                "Ali",
                "Ahmed",
                "ali@mail.com",
                "0600000000",
                "Informatique"
        );

        Reservation reservation = new Reservation();

        reservation.setSalle(salle);
        reservation.setUtilisateur(utilisateur);

        reservation.setDateDebut(LocalDateTime.now().plusDays(1));
        reservation.setDateFin(LocalDateTime.now().plusDays(1).plusHours(2));

        reservation.setStatut(StatutReservation.CONFIRMEE);

        reservationService.create(reservation);

        System.out.println("Réservation créée !");
    }

    // SCENARIO 4 : afficher toutes les réservations
    public static void scenario4_afficherReservations() {

        System.out.println("\n--- Scenario 4 : Liste des réservations ---");

        List<Reservation> reservations = reservationService.findAll();

        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }

    // SCENARIO 5 : annuler une réservation
    public static void scenario5_annulerReservation() {

        System.out.println("\n--- Scenario 5 : Annulation réservation ---");

        Reservation reservation = reservationService.findById(1L);

        if (reservation != null) {

            reservation.setStatut(StatutReservation.ANNULEE);

            reservationService.update(reservation);

            System.out.println("Réservation annulée !");
        } else {
            System.out.println("Réservation introuvable");
        }
    }
}