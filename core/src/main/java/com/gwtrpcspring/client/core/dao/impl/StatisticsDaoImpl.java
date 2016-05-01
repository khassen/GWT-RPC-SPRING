package com.gwtrpcspring.client.core.dao.impl;



import com.gwtrpcspring.client.core.dao.StatisticsDao;
import com.gwtrpcspring.client.core.model.Statistics;

public class StatisticsDaoImpl extends GenericDaoImpl<Statistics, Long> implements StatisticsDao{

	public StatisticsDaoImpl(Class<Statistics> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

}
