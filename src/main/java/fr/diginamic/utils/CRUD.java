package fr.diginamic.utils;

import jakarta.persistence.EntityManager;

public final class CRUD {
    public static void insert(EntityManager em, Object entityRow){
        em.getTransaction().begin();
        em.persist(entityRow);
        em.merge(entityRow);
        em.getTransaction().commit();
    }
}
