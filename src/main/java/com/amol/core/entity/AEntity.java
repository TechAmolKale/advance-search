package com.amol.core.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "A_TABLE")
public class AEntity {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "A_FLD1")
	private String field1;

	@Column(name = "A_FLD2")
	private String field2;

	@JsonManagedReference
	@OneToMany(mappedBy = "aentity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BEntity> bentity;

	@JsonManagedReference
	@OneToMany(mappedBy = "aentity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DEntity> dentity;
}
