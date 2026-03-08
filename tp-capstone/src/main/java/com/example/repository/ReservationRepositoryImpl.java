package com.example.repository;

import com.example.model.Reservation;
import com.example.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {

    @Override
    public void create(Reservation reservation) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(reservation);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Reservation findById(Long id) {

        EntityManager em = JpaUtil.getEntityManager();
        Reservation reservation = em.find(Reservation.class, id);
        em.close();

        return reservation;
    }

    @Override
    public List<Reservation> findAll() {

        EntityManager em = JpaUtil.getEntityManager();

        List<Reservation> reservations =
                em.createQuery("from Reservation", Reservation.class).getResultList();

        em.close();

        return reservations;
    }

    @Override
    public void update(Reservation reservation) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.merge(reservation);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Reservation reservation) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        reservation = em.merge(reservation);
        em.remove(reservation);

        em.getTransaction().commit();
        em.close();
    }
}