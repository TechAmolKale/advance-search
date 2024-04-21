package com.amol.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amol.core.model.QuerySpecification;
import com.amol.core.service.CpiWipService;

@RestController
public class AdvanceQuerySearchController {

	@Autowired
	private CpiWipService service;

	@PostMapping("/executeDynamicQuery")
	public List<Object[]> executeDynamicQuery(@RequestBody QuerySpecification querySpecification) {
		return service.executeDynamicQuery(querySpecification);
	}

}
