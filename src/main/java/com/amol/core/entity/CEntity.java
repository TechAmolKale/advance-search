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
@Table(name = "C_TABLE")
public class CEntity {
	
	@Column(name = "ID")
	private Long id;
	
	@Id
	@Column(name = "B_ID")
	private Long bId;

	@Column(name = "C_FLD1")
	private String field1;

	@Column(name = "A_FLD2")
	private String field2;
	
	@JsonBackReference
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "B_ID", nullable = false, insertable = false, updatable = false)
	private BEntity bentity;
}
