package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Cacheable
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de début est obligatoire")
    @Future(message = "La date doit être dans le futur")
    @Column(name = "date_debut")
    private LocalDateTime dateDebut;

    @NotNull(message = "La date de fin est obligatoire")
    @Column(name = "date_fin")
    private LocalDateTime dateFin;





    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutReservation statut;

    @Column(name = "description")
    private String description;

    // relation avec Salle
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    // relation avec Utilisateur

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    @Version
    private Long version;


    // Constructeur vide
    public Reservation() {
    }

    // Constructeur avec paramètres
    public Reservation(LocalDateTime dateDebut, LocalDateTime dateFin, StatutReservation statut) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", statut=" + statut +
                ", description='" + description + '\'' +
                '}';
    }
}