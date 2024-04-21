package com.amol.core.dao;

import java.util.List;

import com.amol.core.model.QuerySpecification;

public interface CpiWipDao {

	public List<Object[]> executeDynamicQuery(QuerySpecification querySpecification);
}
