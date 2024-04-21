package com.amol.core.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class QuerySpecification implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private List<String> entities;

	@JsonProperty
	private List<JoinSpecification> joins;

	@JsonProperty
	private List<WhereCondition> whereConditions;

}
