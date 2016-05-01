package com.gwtrpcspring.client.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.gwtrpcspring.client.core.dao.LivreDao;
import com.gwtrpcspring.client.core.model.Livre;

@Repository
public class LivreDaoImpl extends GenericDaoImpl<Livre, Long> implements LivreDao{

	public LivreDaoImpl() {
		super(Livre.class);
		// TODO Auto-generated constructor stub
	}
	

	
}
