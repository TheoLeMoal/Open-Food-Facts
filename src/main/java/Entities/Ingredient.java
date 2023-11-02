package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    
    @ManyToMany(mappedBy = "ingredients")
    private List<Produit> produits = new ArrayList<Produit>();

    public Ingredient() {
        // Default constructor
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
    
}