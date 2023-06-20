package fr.diginamic.banque;

import jakarta.persistence.*;

import java.time.LocalDate;
/** Opération */
@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("Operation")
public class Operation {
    /** Identifiant */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Date */
    @Column(name = "date_operation")
    private LocalDate date;
    /** Montant */
    @Column(name = "montant")
    private double montant;
    /** Motif */
    @Column(name = "motif")
    private String motif;
    /** Compte */
    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;
    /** Construction d’opération. */
    public Operation() {
        this.date = LocalDate.now();
        this.montant = 0;
        this.motif = "";
        this.compte = new Compte();
    }

    /** Construction d’opération par les paramètres.
     *
     * @param date Date
     * @param montant Montant
     * @param motif Motif
     */
    public Operation(LocalDate date,
                     double montant,
                     String motif,
                     Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }
}
