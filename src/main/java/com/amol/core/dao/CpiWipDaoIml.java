package com.amol.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.amol.core.model.JoinSpecification;
import com.amol.core.model.QuerySpecification;
import com.amol.core.model.WhereCondition;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CpiWipDaoIml implements CpiWipDao {

	@Autowired
	private EntityManager entityManager ;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Object[]> executeDynamicQuery(QuerySpecification querySpecification) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<?>[] roots = new Root[querySpecification.getEntities().size()];

		// Define roots for each entity
		for (int i = 0; i < querySpecification.getEntities().size(); i++) {
			try {
				roots[i] = criteriaQuery.from(entityManager.getMetamodel()
						.entity(Class.forName("com.amol.core.entity." + querySpecification.getEntities().get(i))));
			} catch (ClassNotFoundException e) {
				log.info("Given Class Is Not Found");
				e.printStackTrace();
			}
		}

		// Perform joins
		for (JoinSpecification join : querySpecification.getJoins()) {
			Join<?, ?> joinQuery = roots[join.getEntityIndex()].join(join.getAssociation());
			criteriaQuery.where(criteriaBuilder.equal(
					roots[join.getEntityIndex()].get(join.getConditions().getField1()),
					joinQuery.get(join.getConditions().getField2())));
		}

		// Add where conditions
		for (WhereCondition whereCondition : querySpecification.getWhereConditions()) {
			if (whereCondition.getEntityIndex() != -1) {
				criteriaQuery.where(criteriaBuilder.equal(roots[whereCondition.getEntityIndex()].get(whereCondition.getField()),
						whereCondition.getValue()));
			} else {
				throw new IllegalArgumentException("Entity not found: " + whereCondition.getEntityIndex());
			}
		}

		// Select
		criteriaQuery.multiselect(roots);

		// Execute query
		List<Object[]> results = entityManager.createQuery(criteriaQuery).getResultList();

		return results;
	}
}
