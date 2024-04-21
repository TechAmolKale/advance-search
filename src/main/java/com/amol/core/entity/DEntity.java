package com.amol.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "D_TABLE")
public class DEntity {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "D_FLD1")
	private String field1;

	@Column(name = "D_FLD2")
	private String field2;

	@JsonBackReference
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID", nullable = false, insertable = false, updatable = false)
	private AEntity aentity;
}
