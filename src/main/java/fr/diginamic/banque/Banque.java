package fr.diginamic.banque;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/** Banque */
@Entity
@Table(name = "Banque")
public class Banque {
    /** Identifiant */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Nom */
    @Column(name = "nom")
    private String nom;
    /** Clients */
    @OneToMany(mappedBy = "banque")
    Set<Client> clients = new HashSet<>();
    /** Construction de banque. */
    public Banque() {
        this.nom = "";
    }

    /** Construction de banque par le nom.
     *
     * @param nom Nom
     */
    public Banque(String nom) {
        this.nom = nom;
    }
    public void add(Client client){
        this.clients.add(client);
    }
}
