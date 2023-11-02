package Dao.Jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import Dao.Dao;
import Entities.Marque;
import Entities.Produit;

public class MarqueDao extends Dao<Marque>{

	public MarqueDao(EntityManager entityManager) {
		super(entityManager);
	}

	public Marque findByName(String marqueName) {
		try {
			Query query = entityManager.createQuery(
					"SELECT c FROM Marque c WHERE c.nom = :nom",
					Marque.class);
			query.setParameter("nom", marqueName);
			return (Marque) query.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}
	}
}
