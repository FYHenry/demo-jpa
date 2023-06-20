package fr.diginamic.banque;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    /** Comptes */
    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "id_client")},
    inverseJoinColumns = {@JoinColumn(name = "id_compte")})
    private Set<Compte> comptes = new HashSet<>();
    /**
     * Construction du client.
     */
    public Client(){
        this.nom = "";
        this.prenom = "";
        this.dateDeNaissance = LocalDate.now();
        this.adresse = new Adresse();
        this.banque = new Banque();
    }

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
    public void add(Compte compte){
        this.comptes.add(compte);
    }
}
