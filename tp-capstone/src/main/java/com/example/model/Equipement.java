package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipements")
@Cacheable
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'équipement est obligatoire")
    @Column(nullable = false)
    private String nom;

    @Column(name = "description")
    private String description;

    // relation avec Salle
    @ManyToMany(mappedBy = "equipements")
    private List<Salle> salles = new ArrayList<>();

    @Version
    private Long version;

    // constructeur vide
    public Equipement() {
    }

    // constructeur avec paramètres
    public Equipement(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // getters et setters

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public Long getVersion() {
        return version;
    }

    // méthodes utilitaires

    public void addSalle(Salle salle) {
        salles.add(salle);
    }

    public void removeSalle(Salle salle) {
        salles.remove(salle);
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}