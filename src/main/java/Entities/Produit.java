package Entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Categorie categorie;

    @ManyToMany
    @JoinTable(
        name = "produit_marque",
        joinColumns = @JoinColumn(name = "produit_id"),
        inverseJoinColumns = @JoinColumn(name = "marque_id")
    )
    private List<Marque> marques = new ArrayList<Marque>();

    private String nom;

    @Enumerated(EnumType.STRING)
    private NutriScore nutritionGrade;

    @ManyToMany
    @JoinTable(
        name = "produit_ingredient",
        joinColumns = @JoinColumn(name = "produit_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients = new ArrayList<Ingredient>(); 

    @OneToOne(cascade = CascadeType.ALL)
    private ValeurNutritionnelle valeurNutritionnelle;

    @OneToOne(cascade = CascadeType.ALL)
    private Vitamine vitamines;

    private int presenceHuilePalme;

    @ManyToMany
    @JoinTable(
        name = "produit_additif",
        joinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "additif_id", referencedColumnName = "id")
    )
    private List<Additif> additifs = new ArrayList<Additif>();

    @ManyToMany
    @JoinTable(
        name = "produit_allergene",
        joinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "allergene_id", referencedColumnName = "id")
    )
    private List<Allergene> allergenes = new ArrayList<Allergene>();


    public Produit() {
        // Default constructor
    }

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Marque> getMarque() {
        return marques;
    }

    public void setMarque(List<Marque> marque) {
        this.marques = marque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NutriScore getNutritionGrade() {
        return nutritionGrade;
    }

    public void setNutritionGrade(NutriScore nutritionGrade) {
        this.nutritionGrade = nutritionGrade;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ValeurNutritionnelle getValeurNutritionnelle() {
        return valeurNutritionnelle;
    }

    public void setValeurNutritionnelle(ValeurNutritionnelle valeurNutritionnelle) {
        this.valeurNutritionnelle = valeurNutritionnelle;
    }

    public Vitamine getVitamines() {
        return vitamines;
    }

    public void setVitamines(Vitamine vitamines) {
        this.vitamines = vitamines;
    }

    public int getPresenceHuilePalme() {
        return presenceHuilePalme;
    }

    public void setPresenceHuilePalme(int presenceHuilePalme) {
        this.presenceHuilePalme = presenceHuilePalme;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

	@Override
	public String toString() {
		return "Produit [id=" + id + ", categorie=" + categorie + ", marques=" + marques + ", nom=" + nom
				+ ", nutritionGrade=" + nutritionGrade + ", ingredients=" + ingredients + ", valeurNutritionnelle="
				+ valeurNutritionnelle + ", vitamines=" + vitamines + ", presenceHuilePalme=" + presenceHuilePalme
				+ ", additifs=" + additifs + ", allergenes=" + allergenes + "]";
	}
    
    
}