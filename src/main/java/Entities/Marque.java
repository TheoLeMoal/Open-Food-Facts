package Entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "marques")
    private List<Produit> produits = new ArrayList<Produit>();

    // Constructors, getters, and setters

    public Marque() {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}