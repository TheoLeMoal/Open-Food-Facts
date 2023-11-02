package Entities;

import javax.persistence.*;

@Entity
public class ValeurNutritionnelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float energie_100g;
    private float graisse_100g;
    private float sucres_100g;
    private float fibres_100g;
    private float proteines_100g;
    private float sel_100g;

    @OneToOne(mappedBy = "valeurNutritionnelle")
    private Produit produit;

    // Constructors, getters, and setters

    public ValeurNutritionnelle() {
        // Default constructor
    }

    // Other constructors

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getEnergie_100g() {
        return energie_100g;
    }

    public void setEnergie_100g(float f) {
        this.energie_100g = f;
    }

    public float getGraisse_100g() {
        return graisse_100g;
    }

    public void setGraisse_100g(float graisse_100g) {
        this.graisse_100g = graisse_100g;
    }

    public float getSucres_100g() {
        return sucres_100g;
    }

    public void setSucres_100g(float sucres_100g) {
        this.sucres_100g = sucres_100g;
    }

    public float getFibres_100g() {
        return fibres_100g;
    }

    public void setFibres_100g(float fibres_100g) {
        this.fibres_100g = fibres_100g;
    }

    public float getProteines_100g() {
        return proteines_100g;
    }

    public void setProteines_100g(float proteines_100g) {
        this.proteines_100g = proteines_100g;
    }

    public float getSel_100g() {
        return sel_100g;
    }

    public void setSel_100g(float sel_100g) {
        this.sel_100g = sel_100g;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}