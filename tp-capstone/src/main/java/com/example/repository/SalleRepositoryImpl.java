package com.example.repository;

import com.example.model.Salle;
import com.example.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class SalleRepositoryImpl implements SalleRepository {

    @Override
    public void create(Salle salle) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(salle);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Salle findById(Long id) {

        EntityManager em = JpaUtil.getEntityManager();
        Salle salle = em.find(Salle.class, id);
        em.close();

        return salle;
    }

    @Override
    public List<Salle> findAll() {

        EntityManager em = JpaUtil.getEntityManager();

        List<Salle> salles =
                em.createQuery("from Salle", Salle.class).getResultList();

        em.close();

        return salles;
    }

    @Override
    public void update(Salle salle) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.merge(salle);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Salle salle) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        salle = em.merge(salle);
        em.remove(salle);

        em.getTransaction().commit();
        em.close();
    }
}