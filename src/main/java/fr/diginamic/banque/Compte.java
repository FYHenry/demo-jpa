package fr.diginamic.banque;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/** Compte */
@Entity
@Table(name = "Compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("Compte")
public class Compte {
    /** Identifiant */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** Numéro */
    @Column(name = "numero")
    private String numero;
    /** Solde */
    @Column(name = "solde")
    private double solde;
    /** Opérations */
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations = new HashSet<>();
    /** Construction de compte. */
    protected Compte() {
        this.numero = "";
        this.solde = 0;
    }

    /**
     * Construction de compte via les paramètres.
     * @param numero
     * @param solde
     */
    protected Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }
    public void add(Operation operation){
        operations.add(operation);
    }
}
