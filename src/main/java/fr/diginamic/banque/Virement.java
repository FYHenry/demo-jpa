package fr.diginamic.banque;

import jakarta.persistence.*;

import java.time.LocalDate;
/** Virement */
@Entity
@Table(name = "Virement")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Virement")
public class Virement extends Operation{
    /** Bénéficiaire */
    @Column(name = "beneficiaire")
    private String beneficiaire;
    /** Construction d’un virement. */
    public Virement() {
        super();
        this.beneficiaire = "";
    }
    /** Construction d’un virement par ses paamètres.
     *
     * @param date Date
     * @param montant Montant
     * @param motif Motif
     * @param beneficiaire Bénéficiaire
     */
    public Virement(LocalDate date,
                    double montant,
                    String motif,
                    Compte compte,
                    String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }
}
