package com.safouan.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "products")
public class Products {
	
	@Id
	@Column(name= "nameproduct")
	private  String name_Products;
	@Column(name= "category")
	private String nameCategory;
	
	
	public Products() {
		super();
	}
	public Products(String name_Products,String nameCategory) {
		super();
		this.name_Products = name_Products;
		this.nameCategory=nameCategory;
	}
	public String getName_Products() {
		return name_Products;
	}
	public void setName_Products(String name_Products) {
		this.name_Products = name_Products;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	





	
	

}
