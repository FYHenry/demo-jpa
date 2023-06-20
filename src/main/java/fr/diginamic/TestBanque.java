package fr.diginamic;

import fr.diginamic.banque.*;
import fr.diginamic.utils.CRUD;
import java.time.LocalDate;

public class TestBanque {
    public static void main(String[] args) {
        final Adresse[] adresses = {
                new Adresse(1,
                        "Rue Stock",
                        30027,
                        "Bladde"),
                new Adresse(2,
                        "Rue Deux",
                        30007,
                        "Be"),
                new Adresse(30,
                        "Rue Droi",
                        30028,
                        "Vel")
        };
        final Banque[] banques = {
                new Banque("Flooz Bank"),
                new Banque("Picsou Bank"),
                new Banque("Rafletout")
        };
        final Client[] clients = {
                new Client("Zo",
                        "Fi",
                        LocalDate.of(1987,
                                1, 4),
                        adresses[0],
                        banques[0]),
                new Client("Bi",
                        "Dul",
                        LocalDate.of(456,
                                3, 7),
                        adresses[1],
                        banques[1]),
                new Client("Toute",
                        "Chose",
                        LocalDate.of(2021,
                                8, 20),
                        adresses[2],
                        banques[2])
        };
        for(int i=0; i<3; i++){
            banques[i].add(clients[i]);
        }
        final Compte[] comptes = {
                new LivretA("001",
                        1,
                        90),
                new LivretA("002",
                        78,
                        13),
                new AssuranceVie("003",
                        0,
                        LocalDate.of(2013, 10,23),
                        100)
        };
        //Compte avec plusieurs clients
        comptes[0].add(clients[0]);
        comptes[0].add(clients[1]);
        //Client avec plusieurs comptes
        comptes[0].add(clients[2]);
        comptes[1].add(clients[2]);
        final Operation[] operations = {
                new Operation(LocalDate.of(2022,7,15),
                        2,
                        "Au pif",
                        comptes[0]),
                new Operation(LocalDate.of(2021,8,12),
                        3,
                        "Comme ça",
                        comptes[0]),
                new Virement(LocalDate.of(1982,1,7),
                        1000,
                        "Inconnu",
                        comptes[1],
                        "Anonymous"),
                new Virement(LocalDate.of(1999,8,6),
                        777,
                        "J’ai envie",
                        comptes[1],
                        "Mémé")
        };
        comptes[0].add(operations[0]);
        comptes[0].add(operations[2]);
        comptes[1].add(operations[1]);
        comptes[1].add(operations[3]);
        for(Banque banque: banques){
            CRUD.insert(banque);
        }
        for(Client client: clients){
            CRUD.insert(client);
        }
        for(Compte compte: comptes){
            CRUD.insert(compte);
        }
        for(Operation operation: operations){
            CRUD.insert(operation);
        }
        CRUD.close();
        System.out.println("DONE.");
    }
}
