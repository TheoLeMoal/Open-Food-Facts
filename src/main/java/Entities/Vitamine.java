package Entities;

import javax.persistence.*;

@Entity
public class Vitamine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float vitA100g;
    private float vitD100g;
    private float vitE100g;
    private float vitK100g;
    private float vitC100g;
    private float vitB1100g;
    private float vitB2100g;
    private float vitPP100g;
    private float vitB6100g;
    private float vitB9100g;
    private float vitB12100g;

    @OneToOne(mappedBy = "vitamines")
    private Produit produit;

    // Constructors, getters, and setters

    public Vitamine() {
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

    public float getVitA100g() {
        return vitA100g;
    }

    public void setVitA100g(float vitA100g) {
        this.vitA100g = vitA100g;
    }

    public float getVitD100g() {
        return vitD100g;
    }

    public void setVitD100g(float vitD100g) {
        this.vitD100g = vitD100g;
    }

    public float getVitE100g() {
        return vitE100g;
    }

    public void setVitE100g(float vitE100g) {
        this.vitE100g = vitE100g;
    }

    public float getVitK100g() {
        return vitK100g;
    }

    public void setVitK100g(float vitK100g) {
        this.vitK100g = vitK100g;
    }

    public float getVitC100g() {
        return vitC100g;
    }

    public void setVitC100g(float vitC100g) {
        this.vitC100g = vitC100g;
    }

    public float getVitB1100g() {
        return vitB1100g;
    }

    public void setVitB1100g(float vitB1100g) {
        this.vitB1100g = vitB1100g;
    }

    public float getVitB2100g() {
        return vitB2100g;
    }

    public void setVitB2100g(float vitB2100g) {
        this.vitB2100g = vitB2100g;
    }

    public float getVitPP100g() {
        return vitPP100g;
    }

    public void setVitPP100g(float vitPP100g) {
        this.vitPP100g = vitPP100g;
    }

    public float getVitB6100g() {
        return vitB6100g;
    }

    public void setVitB6100g(float vitB6100g) {
        this.vitB6100g = vitB6100g;
    }

    public float getVitB9100g() {
        return vitB9100g;
    }

    public void setVitB9100g(float vitB9100g) {
        this.vitB9100g = vitB9100g;
    }

    public float getVitB12100g() {
        return vitB12100g;
    }

    public void setVitB12100g(float vitB12100g) {
        this.vitB12100g = vitB12100g;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
