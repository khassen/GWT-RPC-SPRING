package org.gwtrpcspring.example.web.shared.service;

import java.util.List;

import com.gwtrpcspring.client.core.exception.ServiceException;


public interface GenericService<T , PK> {
	
	public List<T> findAll() throws ServiceException;

	public void delete(PK id) throws ServiceException;

	public T find(PK id) throws ServiceException;

	public void update(T Entite) throws ServiceException;

}
