package com.pojo;

// Generated 27 Nov, 2018 11:28:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Addproduct generated by hbm2java
 */
public class Addproduct implements java.io.Serializable {

	private Integer id;
	private Mainproduct mainproduct;
	private String name;
	private String price;
	private String image;
	private String quantity;
	private Set items = new HashSet(0);

	public Addproduct() {
	}

	public Addproduct(Mainproduct mainproduct, String name, String price, String image, String quantity, Set items) {
		this.mainproduct = mainproduct;
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.items = items;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mainproduct getMainproduct() {
		return this.mainproduct;
	}

	public void setMainproduct(Mainproduct mainproduct) {
		this.mainproduct = mainproduct;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

}
