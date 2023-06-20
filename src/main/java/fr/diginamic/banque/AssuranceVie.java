package fr.diginamic.banque;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
/** Assurance vie */
@Entity
@Table(name = "Assurance_vie")
@DiscriminatorValue("Assurance vie")
public class AssuranceVie extends Compte{
    /** Date de fin */
    @Column(name = "date_fin")
    private LocalDate dateFin;
    /** Taux */
    @Column(name = "taux")
    private double taux;
    /** Construction de l’assurance vie. */
    public AssuranceVie() {
        super();
        this.dateFin = LocalDate.now();
        this.taux = 0;
    }

    /** Construction de l’assurance vie par ses paramètres.
     *
     * @param numero Numéro
     * @param solde Solde
     * @param dateFin Date de fin
     * @param taux Taux
     */
    public AssuranceVie(String numero,
                        double solde,
                        LocalDate dateFin,
                        double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }
}
