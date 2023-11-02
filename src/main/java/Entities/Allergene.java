package Entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "allergene")
public class Allergene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @ManyToMany(mappedBy = "allergenes")
    private List<Produit> produits;

    public Allergene() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
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
}