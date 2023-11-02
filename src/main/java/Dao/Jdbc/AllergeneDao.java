package Dao.Jdbc;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Dao.Dao;
import Entities.Allergene;

public class AllergeneDao extends Dao<Allergene>{

	public AllergeneDao(EntityManager entityManager) {
		super(entityManager);
	}

	public Allergene findByName(String allergeneName) {
		try {
			Query query = entityManager.createQuery(
					"SELECT c FROM Allergene c WHERE c.nom = :nom",
					Allergene.class);
			query.setParameter("nom", allergeneName);
			return (Allergene) query.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}
	}
}
