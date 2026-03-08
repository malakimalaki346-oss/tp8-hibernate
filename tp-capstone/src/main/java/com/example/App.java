package com.example;

import com.example.test.TestScenarios;
import com.example.util.DataInitialiser;
import com.example.util.DatabaseMigrationTool;
import com.example.util.PerformanceReport;
import com.example.util.JpaUtil;

public class App {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   APPLICATION RESERVATION SALLES");
        System.out.println("=================================");

        try {

            // 1️⃣ Migration de la base de données
            System.out.println("\n--- Étape 1 : Migration base de données ---");
            DatabaseMigrationTool.migrate();

            // 2️⃣ Initialisation des données
            System.out.println("\n--- Étape 2 : Initialisation des données ---");
            DataInitialiser.initData();

            // 3️⃣ Exécution des scénarios de test
            System.out.println("\n--- Étape 3 : Exécution des scénarios ---");
            TestScenarios.runAllTests();

            // 4️⃣ Rapport de performance
            System.out.println("\n--- Étape 4 : Rapport de performance ---");
            PerformanceReport.generate();

        } catch (Exception e) {

            System.out.println("Erreur lors de l'exécution de l'application");
            e.printStackTrace();

        } finally {

            // fermeture EntityManagerFactory
            JpaUtil.close();

            System.out.println("\n=================================");
            System.out.println("  FIN DE L'APPLICATION");
            System.out.println("=================================");
        }
    }
}