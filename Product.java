package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@NotNull
	private int prodid;
	private String prodname;
	private int price;
	
	@ManyToOne
	@JoinColumn(name="fid")
	private Catalog catalog;

}
