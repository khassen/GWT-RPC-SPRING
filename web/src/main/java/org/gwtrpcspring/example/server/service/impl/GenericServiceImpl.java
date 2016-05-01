package org.gwtrpcspring.example.server.service.impl;

import java.util.List;

import org.gwtrpcspring.example.web.shared.service.GenericService;
import org.springframework.transaction.annotation.Transactional;

import com.gwtrpcspring.client.core.dao.GenericDao;
import com.gwtrpcspring.client.core.exception.DAOExecption;
import com.gwtrpcspring.client.core.exception.ServiceException;

public abstract class GenericServiceImpl<T, PK, D extends GenericDao<T, PK>> implements GenericService<T, PK>  {

	
	protected abstract D getDAO();
	
	@Transactional
	@Override
	public List<T> findAll() throws ServiceException {
		try {
			return	getDAO().finAll();
		} catch (DAOExecption e) {
		throw new ServiceException(e.getMessage(), e.getCause());
		}
		 
	}

	@Transactional
	@Override
	public void delete(PK id) throws ServiceException {
		try {
			getDAO().remove(id);
		} catch (DAOExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Transactional
	@Override
	public T find(PK id) throws ServiceException {
		try {
			getDAO().findById(id);
		} catch (DAOExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public void update(T Entite) throws ServiceException {
		try {
			getDAO().update(Entite);
		} catch (DAOExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
