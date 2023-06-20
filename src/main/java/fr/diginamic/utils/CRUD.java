package fr.diginamic.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class CRUD {
    final static EntityManagerFactory emf;
    final static EntityManager em;
    static{
        emf = Persistence.createEntityManagerFactory("demo-jpa-banque");
        em = emf.createEntityManager();
    }
    private CRUD(){}
    public static void insert(Object entityRow){
        em.getTransaction().begin();
        em.persist(entityRow);
        em.merge(entityRow);
        em.getTransaction().commit();
    }
    public static void close(){
        em.close();
        emf.close();
    }
    public static <T> T find(Class<T> entityClass, Object primaryKey){
        return em.find(entityClass, primaryKey);
    }
}
