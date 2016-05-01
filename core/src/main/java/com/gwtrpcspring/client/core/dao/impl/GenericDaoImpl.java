package com.gwtrpcspring.client.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.gwtrpcspring.client.core.dao.GenericDao;
import com.gwtrpcspring.client.core.exception.DAOExecption;

public class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

	// aprés ca sera injecter par spring
	// private static EntityManager entityManager =
	// Persistence.createEntityManagerFactory("livre").createEntityManager();

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		super();
		this.type = type;

	}

	@Override
	public T save(T entity) throws DAOExecption {

		try {
			getEntityManager().persist(entity);
			return entity;
		} catch (PersistenceException exception) {
			throw new DAOExecption(exception.getMessage(), exception.getCause());

		}

	}

	@Override
	public T findById(PK id) throws DAOExecption {
		if (id == null)
			return null;
		try {
			return getEntityManager().find(type, id);
		} catch (PersistenceException e) {
			throw new DAOExecption(e.getMessage(), e.getCause());
		}

	}

	@Override
	public List<T> finAll() throws DAOExecption {
		List<T> listeLivre = getEntityManager().createQuery(
				"select o FROM"+type.getSimpleName()+"o", type).getResultList();
		return listeLivre;
	}

	@Override
	public void remove(PK id) throws DAOExecption {

		if (getEntityManager().contains(type))
			getEntityManager().remove(type);
		else {
			T attachedEntite = getEntityManager().find(type, id);
			getEntityManager().remove(attachedEntite);

		}

	}
	
	public void remoe2(PK id) throws DAOExecption{
		try{
		Query query = entityManager.createQuery("delete o from"+type.getSimpleName()+"o where o.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		}catch(PersistenceException exception){
			throw new DAOExecption(exception.getMessage(), exception.getCause());
		}
	}

	public boolean contains(T entity) {
		return getEntityManager().contains(entity);

	}

	@Override
	public T update(T entite) throws DAOExecption {
		try{

		return getEntityManager().merge(entite);
		}catch(PersistenceException exception){
			throw new DAOExecption(exception.getMessage(), exception.getCause());
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
