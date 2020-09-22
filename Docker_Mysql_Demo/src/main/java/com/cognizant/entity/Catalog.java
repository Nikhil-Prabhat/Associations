package com.cognizant.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Catalog {
	
	@Id
	@NotNull
	@Min(1)
	private int catid;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z]{1}.*")
	private String catname;
	
	@OneToMany(mappedBy = "catalog")
	private List<Product> products = new ArrayList<>();

}
