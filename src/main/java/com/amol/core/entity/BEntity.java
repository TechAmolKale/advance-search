package com.amol.core.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "B_TABLE")
public class BEntity {

	@Column(name = "ID")
	private Long id;
	
	@Id
	@Column(name = "B_ID")
	private Long bId;

	@Column(name = "B_FLD1")
	private String field1;

	@Column(name = "B_FLD2")
	private String field2;

	@JsonBackReference
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID", nullable = false, insertable = false, updatable = false)
	private AEntity aentity;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bentity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CEntity> centity;
}
