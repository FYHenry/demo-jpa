package fr.diginamic;

import fr.diginamic.banque.*;
import fr.diginamic.utils.CRUD;
import java.time.LocalDate;

public class TestBanque {
    public static void main(String[] args) {
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
        CRUD.insert(banque);
        CRUD.insert(client);
        System.out.println(CRUD.find(Client.class, 1));
        Compte livretA = new LivretA("001", 1, 10);
        CRUD.insert(livretA);
        Operation operation = new Operation(LocalDate.of(2021, 3, 2),
                23,
                "Au pif",
                livretA);
        CRUD.insert(operation);
        livretA.add(operation);
        operation = new Virement(LocalDate.of(2011, 4, 5),
                47,
                "Cadeau",
                livretA,
                "Mémé");
        CRUD.insert(operation);
        livretA.add(operation);
        CRUD.insert(livretA);
        CRUD.insert(new AssuranceVie("002",
                10,
                LocalDate.of(1992,11,7),
                12));
        CRUD.close();
        System.out.println("DONE.");
    }
}
