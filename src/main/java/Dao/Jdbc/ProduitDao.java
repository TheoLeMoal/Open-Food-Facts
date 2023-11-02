package Dao.Jdbc;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Dao.Dao;
import Entities.Produit;

public class ProduitDao extends Dao<Produit>{
	public ProduitDao(EntityManager entityManager) {
		super(entityManager);
	}

	/**
	 * Trouve un produit grace au nom
	 * @param produitName
	 * @return
	 */
	public Produit findByName(String produitName) {
		try {
			Query query = entityManager.createQuery(
					"SELECT c FROM Produit c WHERE c.nom = :nom",
					Produit.class);
			query.setParameter("nom", produitName);
			return (Produit) query.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}
	}
	
	/**
	 * Recherche 10 produit d'une categorie
	 * @param categorie
	 * @return
	 */
	public List<Produit> produitParCategorie(String categorie) {
		try {
			String jpqlQuery = "SELECT p FROM Produit p WHERE p.categorie.nom = :categorie ORDER BY p.nutritionGrade ASC";
			TypedQuery<Produit> query = entityManager.createQuery(jpqlQuery, Produit.class);
			query.setParameter("categorie", categorie);
			query.setMaxResults(10);
			List<Produit> topRatedProducts = query.getResultList();
			return topRatedProducts;
		} catch (NoResultException e) {
			return null; 
		}
	}
	
	/**
	 * Recherche 10 produit d'une marque
	 * @param marque
	 * @return
	 */
	public List<Produit> produitParMarque(String marque) {
		try {
			String jpqlQuery = "SELECT p FROM Produit p JOIN p.marques m WHERE m.nom = :marque ORDER BY p.nutritionGrade ASC";
			TypedQuery<Produit> query = entityManager.createQuery(jpqlQuery, Produit.class);
			query.setParameter("marque", marque);
			query.setMaxResults(10);
			List<Produit> topRatedProducts = query.getResultList();
			return topRatedProducts;
		} catch (NoResultException e) {
			return null; 
		}
	}
	
	/**
	 * Recherche 10 produit d'une categorie donnée qui ne posseide pas un ingredient donnée
	 * @param categorie
	 * @param ingredientExclu
	 * @return
	 */
	public List<Produit> produitParCategorieSansIngredient(String categorie, String ingredientExclu){
		try {
			String jpqlQuery = "SELECT p FROM Produit p " +
	                  "WHERE p.categorie.nom = :categorie " +
	                  "AND NOT EXISTS (SELECT i FROM Ingredient i WHERE i.nom = :ingredientExclu " +
	                  "AND i MEMBER OF p.ingredients) " +
	                  "ORDER BY p.nutritionGrade DESC";

			TypedQuery<Produit> query = entityManager.createQuery(jpqlQuery, Produit.class)
			        .setParameter("categorie", categorie)
			        .setParameter("ingredientExclu", ingredientExclu)
			        .setMaxResults(10);

			List<Produit> produits = query.getResultList();
			return produits; 
		} catch (Exception e) {
			return null; 
		}
	}
	
	/**
	 * Recherche 10 produit d'une marque donnée qui ne posseide pas un ingredient donnée
	 * @param marque
	 * @param ingredientExclu
	 * @return
	 */
	public List<Produit> produitParMarqueSansIngredient(String marque, String ingredientExclu){
		try {
			String jpqlQuery = "SELECT p FROM Produit p " +
	                  "WHERE p.marque.nom = :marque " +
	                  "AND NOT EXISTS (SELECT i FROM Ingredient i WHERE i.nom = :ingredientExclu " +
	                  "AND i MEMBER OF p.ingredients) " +
	                  "ORDER BY p.nutritionGrade DESC";

			TypedQuery<Produit> query = entityManager.createQuery(jpqlQuery, Produit.class)
			        .setParameter("marque", marque)
			        .setParameter("ingredientExclu", ingredientExclu)
			        .setMaxResults(10);

			List<Produit> produits = query.getResultList();
			return produits; 
		} catch (Exception e) {
			return null; 
		}
	}
	
	/**
	 * Recherche 10 produit d'une categorie donnée qui ne posseide pas un allergene donnée
	 * @param categorie
	 * @param allergeneExclu
	 * @return
	 */
	public List<Produit> produitParCategorieSansAllergene(String categorie, String allergeneExclu){
		try {
			String jpqlQuery = "SELECT p FROM Produit p " +
	                  "WHERE p.categorie.nom = :categorie " +
	                  "AND NOT EXISTS (SELECT a FROM Allergene a WHERE a.nom = :allergeneExclu " +
	                  "AND a MEMBER OF p.allergenes) " +
	                  "ORDER BY p.nutritionGrade DESC";

			TypedQuery<Produit> query = entityManager.createQuery(jpqlQuery, Produit.class)
			        .setParameter("categorie", categorie)
			        .setParameter("allergeneExclu", allergeneExclu)
			        .setMaxResults(10);

			List<Produit> produits = query.getResultList();
			return produits; 
		} catch (Exception e) {
			return null; 
		}
	}
	
	/**
	 * Recherche 10 produit d'une marque donnée qui ne posseide pas un allergene donnée
	 * @param marque
	 * @param allergeneExclu
	 * @return
	 */
	public List<Produit> produitParMarqueSansAllergene(String marque, String allergeneExclu){
		try {
			String jpqlQuery = "SELECT p FROM Produit p " +
	                  "WHERE p.marque.nom = :marque " +
	                  "AND NOT EXISTS (SELECT a FROM Allergene a WHERE a.nom = :allergeneExclu " +
	                  "AND a MEMBER OF p.allergenes) " +
	                  "ORDER BY p.nutritionGrade DESC";

			TypedQuery<Produit> query = entityManager.createQuery(jpqlQuery, Produit.class)
			        .setParameter("marque", marque)
			        .setParameter("ingredientExclu", allergeneExclu)
			        .setMaxResults(10);

			List<Produit> produits = query.getResultList();
			return produits; 
		} catch (Exception e) {
			return null; 
		}
	}
}
