package fr.diginamic.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/** Emprunt */
@Entity
@Table(name = "Emprunt")
public class Emprunt {
    /** Identifiant */
    @Id
    @Column(name = "id")
    private int id;
    /** Date de début */
    @Column(name = "date_debut")
    private Date dateDebut;
    /** Délai (jours) */
    @Column(name = "delai")
    private int delai;
    /** Date de fin */
    @Column(name = "date_fin")
    private Date dateFin;
    /** Client */
    @ManyToOne
    @JoinColumn(name = "id_client", nullable=false)
    private Client client;
    /** Compositions */
    @OneToMany(mappedBy = "emprunt")
    private final Set<Compo> compos = new HashSet<>();

    /**
     * Construire l’emprunt
     */
    public Emprunt() {}

    /**
     * Construire l’emprunt via plusieurs paramètres.
     * @param dateDebut Date de début
     * @param delai Délai (jours)
     * @param dateFin Date de fin
     * @param client Client
     */
    public Emprunt(Date dateDebut, int delai, Date dateFin, Client client) {
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
        this.client = client;
    }

    /** Texte d’affichage
     *
     * @return Texte
     */
    @Override
    public String toString() {
        return String.format("""
                {
                    "id":%d,
                    "date_debut":"%tF",
                    "delai":%d,
                    "date_fin:"%tF",
                    "client":%s,
                    "livres":%s
                }
                """,
                this.id,
                this.dateDebut,
                this.delai,
                this.dateFin,
                this.client,
                this.getLivres());
    }
    public Set<Livre> getLivres(){
        final Set<Livre> livres = new HashSet<>();

        for (Compo compo : this.compos) {
            livres.add(compo.getLivre());
        }
        return livres;
    }
}
