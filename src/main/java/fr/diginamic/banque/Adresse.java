package fr.diginamic.banque;

import jakarta.persistence.*;

/** Adresse */
@Embeddable
@Table(name = "Adresse")
public class Adresse {
    /* Identifiant */
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;
    /** Numéro */
    @Column(name = "numero")
    private int numero;
    /** Rue */
    @Column(name = "rue")
    private String rue;
    /** Code postal */
    @Column(name = "code_postal")
    private int codePostal;
    /** Ville */
    @Column(name = "ville")
    private String ville;
    /* Client */
    //@OneToOne(mappedBy = "adresse", cascade = CascadeType.ALL)
    //private Client client;
    /** Construction d’une adresse. */
    public Adresse() {
        this.numero = 0;
        this.rue = "";
        this.codePostal = 0;
        this.ville = "";
    }

    /** Construction d’une adresse par ses paramètres.
     *
     * @param numero Numéro
     * @param rue Rue
     * @param codePostale Code postale
     * @param ville Ville
     */
    public Adresse(int numero, String rue, int codePostale, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostale;
        this.ville = ville;
    }
}
