package com.cognizant.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.mapping.AccessOptions.GetOptions.GetNulls;

import lombok.Data;

@Entity
@Data
public class Catalog {

	@Id
	@NotNull
	@Min(1)
	private int catid;

	@NotNull
	@Pattern(regexp = "[a-zA-Z]{1}.*")
	private String catname;

	
	//All the columns of the product will be joined according to fid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn(name="fid")
	private List<Product> products = new ArrayList<>();

}
