package com.cognizant.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MCatalog {

	private int catid;

	private String catname;

	private List<MProduct> products=new ArrayList<>();

}
