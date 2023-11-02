package Dao.Jdbc;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Dao.Dao;
import Entities.Categorie;
import Entities.Produit;

public class CategorieDao extends Dao<Categorie> {
	public CategorieDao(EntityManager entityManager) {
		super(entityManager);
	}

	public Categorie findByName(String categoryName) {
		try {
			
			Query query = entityManager.createQuery("SELECT c FROM Categorie c WHERE c.nom = :nom", Categorie.class);
			query.setParameter("nom", categoryName);
			return (Categorie) query.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}
	}

	public void createIfNotExists(String categorieName, Produit produit) {
		Categorie existingCategorie = findByName(categorieName);
		if (existingCategorie == null) {
			Categorie newCategorie = new Categorie();
			newCategorie.setNom(categorieName);
			create(newCategorie);
		}else {
			existingCategorie.getProduits().add(produit);
			update(existingCategorie);
		}
	}
}
