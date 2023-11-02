package Dao.Jdbc;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import Dao.Dao;
import Entities.Ingredient;

public class IngredientDao extends Dao<Ingredient>{
	
	public IngredientDao(EntityManager entityManager) {
		super(entityManager);
	}

	public Ingredient findByName(String ingredientName) {
		try {
			Query query = entityManager.createQuery(
					"SELECT c FROM Ingredient c WHERE c.nom = :nom",
					Ingredient.class);
			query.setParameter("nom", ingredientName);
			return (Ingredient) query.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}
	}

	public Ingredient createIfNotExist(String ingredientName) {
		Ingredient existingIngredient = findByName(ingredientName);
		if (existingIngredient == null) {
			Ingredient newIngredient = new Ingredient();
			newIngredient.setNom(ingredientName);
			create(newIngredient);
			return newIngredient;
		}
		return null;
	}
}
