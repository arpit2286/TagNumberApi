package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
class Product {

	private @Id String id;
	@ElementCollection
	private List<String> skus = new ArrayList<String>();

	Product() {

	}

	public Product(String id, List<String> skus) {
		super();
		this.id = id;
		this.skus = skus;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getSkus() {
		return skus;
	}

	public void setSkus(List<String> skus) {
		this.skus = skus;
	}

	

}
