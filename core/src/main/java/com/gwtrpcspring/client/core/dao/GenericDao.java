package com.gwtrpcspring.client.core.dao;

import java.util.List;

import com.gwtrpcspring.client.core.exception.DAOExecption;

public interface GenericDao<T,PK> {
	 
	T save(T entity) throws DAOExecption;
	T findById(PK id) throws DAOExecption;
	List<T> finAll() throws DAOExecption;
	void remove(PK id) throws DAOExecption;
	T update(T entite) throws DAOExecption;
	

}
