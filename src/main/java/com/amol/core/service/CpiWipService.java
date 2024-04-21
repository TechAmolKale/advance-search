package com.amol.core.service;

import java.util.List;

import com.amol.core.model.QuerySpecification;

public interface CpiWipService {

	public List<Object[]> executeDynamicQuery(QuerySpecification querySpecification);
}
