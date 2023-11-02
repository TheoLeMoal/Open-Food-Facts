package Dao.Jdbc;

import javax.persistence.EntityManager;

import Dao.Dao;
import Entities.Vitamine;

public class VitamineDao extends Dao<Vitamine>{

	public VitamineDao(EntityManager entityManager) {
		super(entityManager);
	}
}