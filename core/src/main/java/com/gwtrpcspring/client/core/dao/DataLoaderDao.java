package com.gwtrpcspring.client.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gwtrpcspring.client.core.exception.DAOExecption;
import com.gwtrpcspring.client.core.model.Livre;
import com.gwtrpcspring.client.core.model.Statistics;



@Repository
public class DataLoaderDao {
	private StatisticsDao statisticsDao;
	private LivreDao livreDao;

	public LivreDao getLivreDao() {
		return livreDao;
	}

	public void setLivreDao(LivreDao livreDao) {
		this.livreDao = livreDao;
	}

	@PersistenceContext(unitName = "persistenceUnit")
	EntityManager entityManager;


	public StatisticsDao getStatisticsDao() {
		return statisticsDao;
	}

	public void setStatisticsDao(StatisticsDao statisticDao) {
		this.statisticsDao = statisticDao;
	}
	
	@Transactional()
	public void loadData() throws DAOExecption  {
		Statistics statistics = new Statistics();

		statistics.setAverageduration(1L);
		statistics.setClientapp("cliapp");
		statistics.setClientidentity("clitity");
		statistics.setConnectiontype("1");
		statistics.setDayofyear("152");
		statistics.setDomain("domain");
		statistics.setExecutionenvironment("X");
		statistics.setGeographicsite("geo");
		statistics.setHourslot("01");
		statistics.setMaximumduration(1L);
		statistics.setMinimumduration(1L);
		statistics.setNumberbelow100(1L);
		statistics.setNumberbetween1000030000(1L);
		statistics.setNumberbetween10002000(1L);
		statistics.setNumberbetween100500(1L);
		statistics.setNumberbetween20005000(1L);
		statistics.setNumberbetween500010000(1L);
		statistics.setNumberbetween5001000(1L);
		statistics.setNumberofbytes(1L);
		statistics.setNumberoferrors(1L);
		statistics.setNumberofservice(1L);
		statistics.setNumberupper30000(1L);
		statistics.setOriginetype("O");
		statistics.setProtocol("p");
		statistics.setServerapp("S");
		statistics.setServername("servername");
		statistics.setServicenumber("1");
		statistics.setTechnotype("t");
		statistics.setValuelevel("v");

		statisticsDao.save(statistics);
		
		livreDao.save(new Livre("L'art du developpement Android"));
		livreDao.save(new Livre("Merise et UML"));
		livreDao.save(new Livre("La prophetie des Andes"));
		livreDao.save(new Livre("L'enchanteur"));
		livreDao.save(new Livre("Chat blanc, Chat noir"));
		livreDao.save(new Livre("200 recettes minceurs"));
		livreDao.save(new Livre("La psychologie pour les cons"));
		System.out.println("Fin de chargement");
		
	}
}
