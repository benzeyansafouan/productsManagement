package com.safouan.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "category")
public class Category {

	@Id
	@Column(name= "id")
	private  String nameCategory;
	
	
	public Category() {
		super();
	}
	
	
	
	public Category(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}
	
	
	
	public String getNameCategory() {
		return nameCategory;
	}



	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	
}
