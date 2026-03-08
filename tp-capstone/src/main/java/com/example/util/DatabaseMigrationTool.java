package com.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseMigrationTool {

    public static void migrate() {

        System.out.println("Début migration base de données...");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("reservationPU");

        emf.close();

        System.out.println("Migration terminée.");
    }
}