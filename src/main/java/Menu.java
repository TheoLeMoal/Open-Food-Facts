import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dao.Jdbc.AdditifDao;
import Dao.Jdbc.AllergeneDao;
import Dao.Jdbc.CategorieDao;
import Dao.Jdbc.IngredientDao;
import Dao.Jdbc.MarqueDao;
import Dao.Jdbc.ProduitDao;
import Dao.Jdbc.VitamineDao;
import Entities.Produit;

public class Menu {	

	
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts");
        EntityManager em = emf.createEntityManager();
        
        //Dao
        ProduitDao produitDao = new ProduitDao(em);
    	
        while(true){
            String menu = "1 - Rechercher les meilleurs produits d'une Marque."+
            			  "\n2 - Rechercher les meilleurs produits d'une Catégorie."+
            			  "\n2 - Rechercher les meilleurs produits d'une Catégorie."+
            			  "\n3 - Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un ingrédient donné"+
            			  "\n4 - Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un ingrédient donné."+
            			  "\n4 - Afficher les ingrédients les plus courants avec le nombre de produits dans lesquels ils apparaissent."+
            			  "\n5 - Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un allergène donné."+
            			  "\n6 - Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un allergène donné."+
            			  "\n7 - Exit.";
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                	try {
                        // Rechercher les 10 meilleurs produits pour une Marque donnée. La marque estdemandées à l’utilisateur
                        System.out.println("Marque :");
                        String marque = scanner.next();
                        List<Produit> produits = produitDao.produitParMarque(marque);
                        for (Produit produit : produits) {
    						System.out.println(produit);
    					}
					} catch (Exception e) {
						e.getStackTrace();
					}

                    break;
                case 2:
                	try {
                        // Rechercher les 10 meilleurs produits pour une Catégorie donnée. La catégorie est demandées à l’utilisateur
                        System.out.println("Catégorie :");
                        String categorie = scanner.next();
                        List<Produit> produits = produitDao.produitParCategorie(categorie);
                        for (Produit produit : produits) {
    						System.out.println(produit);
    					}
					} catch (Exception e) {
						e.getStackTrace();
					}
                    break;
                case 3:
                	try {
                        // Rechercher les 10 meilleurs produits pour une Catégorie donnée qui ne posseide pas un ingredient donnée. La catégorie et l'ingredient sont demandées à l’utilisateur
                        System.out.println("Catégorie :");
                        String categorie = scanner.next();
                        System.out.println("Ingredient :");
                        String ingredient = scanner.next();
                        List<Produit> produits = produitDao.produitParCategorieSansIngredient(categorie, ingredient);
                        for (Produit produit : produits) {
    						System.out.println(produit);
    					}
					} catch (Exception e) {
						e.getStackTrace();
					}
                case 4 :
                	try {
                        // Rechercher les 10 meilleurs produits pour une Marque donnée qui ne posseide pas un ingredient donnée. La Marque et l'ingredient sont demandées à l’utilisateur
                        System.out.println("Marque :");
                        String marque = scanner.next();
                        System.out.println("Ingredient :");
                        String ingredient = scanner.next();
                        List<Produit> produits = produitDao.produitParMarqueSansIngredient(marque, ingredient);
                        for (Produit produit : produits) {
    						System.out.println(produit);
    					}
					} catch (Exception e) {
						e.getStackTrace();
					}
                case 5 :
                	try {
                        // Rechercher les 10 meilleurs produits pour une Marque donnée qui ne posseide pas un ingredient donnée. La Marque et l'ingredient sont demandées à l’utilisateur
                        System.out.println("Categorie :");
                        String categorie = scanner.next();
                        System.out.println("Allergene :");
                        String allergene = scanner.next();
                        List<Produit> produits = produitDao.produitParCategorieSansAllergene(categorie, allergene);
                        for (Produit produit : produits) {
    						System.out.println(produit);
    					}
					} catch (Exception e) {
						e.getStackTrace();
					}
                    break;
                case 6 :
                	try {
                        // Rechercher les 10 meilleurs produits pour une Marque donnée qui ne posseide pas un ingredient donnée. La Marque et l'ingredient sont demandées à l’utilisateur
                        System.out.println("Marque :");
                        String marque = scanner.next();
                        System.out.println("Allergene :");
                        String allergene = scanner.next();
                        List<Produit> produits = produitDao.produitParMarqueSansAllergene(marque, allergene);
                        for (Produit produit : produits) {
    						System.out.println(produit);
    					}
					} catch (Exception e) {
						e.getStackTrace();
					}
                    break;
                case 7:
                    // Fin de l'application
                    System.out.println("Fin de l'application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }
}
