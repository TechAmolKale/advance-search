package com.amol.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.core.dao.CpiWipDao;
import com.amol.core.model.QuerySpecification;

@Service
public class CpiWipServiceImpl implements CpiWipService {

	@Autowired
	private CpiWipDao dao;

	@Override
	public List<Object[]> executeDynamicQuery(QuerySpecification querySpecification) {
		return dao.executeDynamicQuery(querySpecification);
	}

}
