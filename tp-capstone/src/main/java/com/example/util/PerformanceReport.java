package com.example.util;

import com.example.service.ReservationService;
import com.example.service.ReservationServiceImpl;

public class PerformanceReport {

    public static void generate() {

        ReservationService service = new ReservationServiceImpl();

        long start = System.currentTimeMillis();

        service.findAll();

        long end = System.currentTimeMillis();

        System.out.println("===== RAPPORT PERFORMANCE =====");
        System.out.println("Temps d'exécution : " + (end - start) + " ms");
    }
}