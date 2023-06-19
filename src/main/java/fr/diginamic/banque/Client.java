package fr.diginamic.banque;

import jakarta.persistence.*;

import java.time.LocalDate;
/** Client */
@Entity
@Table(name = "Client")
public class Client {
    /** Identifiant */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Nom */
    @Column(name = "nom")
    private String nom;
    /** Prénom */
    @Column(name = "prenom")
    private String prenom;
    /** Date de naissance */
    @Column(name = "date_naissance")
    private LocalDate dateDeNaissance;
    /** Adresse */
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_adresse")
    @Embedded
    private Adresse adresse;
    /** Banque */
    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;
    /**
     * Construction du client.
     */
    public Client(){}

    /** Construction du client par ses paramètres.
     *
     * @param nom Nom
     * @param prenom Prénom
     * @param dateDeNaissance Date de naissance
     */
    public Client(String nom,
                  String prenom,
                  LocalDate dateDeNaissance,
                  Adresse adresse,
                  Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
        this.banque = banque;
    }
}
