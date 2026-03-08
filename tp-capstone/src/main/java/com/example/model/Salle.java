package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "salles")
@Cacheable
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la salle est obligatoire")
    @Column(nullable = false)
    private String nom;

    @Min(value = 1, message = "La capacité doit être supérieure à 0")
    private int capacite;

    @Column(name = "localisation")
    private String localisation;

    // relation avec Equipement
    @ManyToMany
    @JoinTable(
            name = "salle_equipements",
            joinColumns = @JoinColumn(name = "salle_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private List<Equipement> equipements = new ArrayList<>();

    // relation avec Reservation
    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    @Version
    private Long version;

    // Constructeur vide
    public Salle() {
    }

    // Constructeur avec paramètres
    public Salle(String nom, int capacite, String localisation) {
        this.nom = nom;
        this.capacite = capacite;
        this.localisation = localisation;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Long getVersion() {
        return version;
    }

    // Méthodes utilitaires

    public void addEquipement(Equipement equipement) {
        equipements.add(equipement);
    }

    public void removeEquipement(Equipement equipement) {
        equipements.remove(equipement);
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", capacite=" + capacite +
                ", localisation='" + localisation + '\'' +
                '}';
    }
}