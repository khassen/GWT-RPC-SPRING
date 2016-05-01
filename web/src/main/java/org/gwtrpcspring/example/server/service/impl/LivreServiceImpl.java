package org.gwtrpcspring.example.server.service.impl;

import org.gwtrpcspring.example.web.shared.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwtrpcspring.client.core.dao.LivreDao;
import com.gwtrpcspring.client.core.model.Livre;

@Service
public class LivreServiceImpl extends GenericServiceImpl<Livre, Long, LivreDao> implements
		LivreService {

	@Autowired
	private LivreDao livreDao;


	@Override
	protected LivreDao getDAO() {
		// TODO Auto-generated method stub
		return livreDao;
	}


	public LivreDao getLivreDao() {
		return livreDao;
	}


	public void setLivreDao(LivreDao livreDao) {
		this.livreDao = livreDao;
	}

	
}
