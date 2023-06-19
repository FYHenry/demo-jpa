package fr.diginamic;

import fr.diginamic.banque.Adresse;
import fr.diginamic.banque.Banque;
import fr.diginamic.banque.Client;
import fr.diginamic.utils.CRUD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class TestBanque {
    public static void main(String[] args) {
        try(EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("demo-jpa-banque");
            EntityManager em = emf.createEntityManager()){
            final Adresse adresse = new Adresse(1,
                    "Rue Stock",
                    30027,
                    "Bladde");
            final Banque banque = new Banque("Banque");
            final Client client = new Client("Nom",
                    "Prénom",
                    LocalDate.of(1992, 2, 7),
                    adresse,
                    banque);
            //CRUD.insert(em, adresse);
            CRUD.insert(em, banque);
            CRUD.insert(em, client);
            System.out.println(em.find(Client.class, 1));
            System.out.println("DONE.");
        }

    }
}
