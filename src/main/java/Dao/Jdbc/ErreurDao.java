package Dao.Jdbc;

import javax.persistence.EntityManager;

import Dao.Dao;
import Entities.Erreur;

public class ErreurDao extends Dao<Erreur>{

	public ErreurDao(EntityManager entityManager) {
		super(entityManager);
	}

}
