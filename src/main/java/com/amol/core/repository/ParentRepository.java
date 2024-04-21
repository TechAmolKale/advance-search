package com.amol.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.core.entity.AEntity;

public interface ParentRepository extends JpaRepository<AEntity, Long> {

}
