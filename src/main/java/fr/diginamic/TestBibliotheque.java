package fr.diginamic;

import fr.diginamic.entities.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TestBibliotheque {
    public static void main(String[] args) {
        try(EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("demo-jpa");
                EntityManager em = emf.createEntityManager()){
            String query = "SELECT e FROM Emprunt e WHERE id=1";
            final TypedQuery<Emprunt> empruntTQ =
                    em.createQuery(query, Emprunt.class);
            for (Emprunt emprunt : empruntTQ.getResultList()) {
                System.out.println(emprunt);
            }
        }
    }
}