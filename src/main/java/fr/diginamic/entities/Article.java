package fr.diginamic.entities;

import jakarta.persistence.*;

/** Article */
@Entity
@Table(name="ARTICLE")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="REF")
    private String ref;
    @Column(name="DESIGNATION")
    private String designation;
    @Column(name="PRIX")
    private double prix;

    public Article(){}

    public Article(int id, String ref, String designation, double prix) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return String.format("""
                {
                    ID:%d,
                    REF:%s,
                    DESIGNATION:%s,
                    PRIX:%f
                }
                """,
                this.id,
                this.ref,
                this.designation,
                this.prix);
    }
}
