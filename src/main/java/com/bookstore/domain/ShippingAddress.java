package com.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ShippingAddressName;
	private String ShippingAddressStreet1;
	private String ShippingAddressStreet2;
	private String ShippingAddressCity;
	private String ShippingAddressState;
	private String ShippingAddressCountry;
	private String ShippingAddressZipcode;
	
	@OneToOne
	private Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Long getId() {
		return id;
	}
	public String getShippingAddressName() {
		return ShippingAddressName;
	}
	public String getShippingAddressStreet1() {
		return ShippingAddressStreet1;
	}
	public String getShippingAddressStreet2() {
		return ShippingAddressStreet2;
	}
	public String getShippingAddressCity() {
		return ShippingAddressCity;
	}
	public String getShippingAddressState() {
		return ShippingAddressState;
	}
	public String getShippingAddressCountry() {
		return ShippingAddressCountry;
	}
	public String getShippingAddressZipcode() {
		return ShippingAddressZipcode;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setShippingAddressName(String shippingAddressName) {
		ShippingAddressName = shippingAddressName;
	}
	public void setShippingAddressStreet1(String shippingAddressStreet1) {
		ShippingAddressStreet1 = shippingAddressStreet1;
	}
	public void setShippingAddressStreet2(String shippingAddressStreet2) {
		ShippingAddressStreet2 = shippingAddressStreet2;
	}
	public void setShippingAddressCity(String shippingAddressCity) {
		ShippingAddressCity = shippingAddressCity;
	}
	public void setShippingAddressState(String shippingAddressState) {
		ShippingAddressState = shippingAddressState;
	}
	public void setShippingAddressCountry(String shippingAddressCountry) {
		ShippingAddressCountry = shippingAddressCountry;
	}
	public void setShippingAddressZipcode(String shippingAddressZipcode) {
		ShippingAddressZipcode = shippingAddressZipcode;
	}
	
	

}
