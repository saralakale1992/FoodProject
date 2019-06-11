package com.pojo;

// Generated 27 Nov, 2018 11:28:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Orderstatus generated by hbm2java
 */
public class Orderstatus implements java.io.Serializable {

	private Integer id;
	private Registration registration;
	private Item item;
	private Date deliverydate;
	private String total;
	private String type;

	public Orderstatus() {
	}

	public Orderstatus(Registration registration, Item item, Date deliverydate, String total, String type) {
		this.registration = registration;
		this.item = item;
		this.deliverydate = deliverydate;
		this.total = total;
		this.type = type;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Registration getRegistration() {
		return this.registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getDeliverydate() {
		return this.deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
