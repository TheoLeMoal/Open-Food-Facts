package Dao.Jdbc;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Dao.Dao;
import Entities.Additif;

public class AdditifDao extends Dao<Additif>{

	public AdditifDao(EntityManager entityManager) {
		super(entityManager);
	}

	public Additif findByName(String additifName) {
		try {
			Query query = entityManager.createQuery(
					"SELECT c FROM Additif c WHERE c.nom = :nom",
					Additif.class);
			query.setParameter("nom", additifName);
			return (Additif) query.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}
	}
}
