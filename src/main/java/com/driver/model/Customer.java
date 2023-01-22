package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Customer
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CustomerId;
	
	private String Mobile;
	
	private String Password;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<TripBooking> trips;

	public int getCustomerid() {
		return CustomerId;
	}

	public void setCustomerid(int customerid) {
		CustomerId = customerid;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<TripBooking> getTrips() {
		return trips;
	}

	public void setTrips(List<TripBooking> trips) {
		this.trips = trips;
	}

	public Customer(int customerid, String mobile, String password, List<TripBooking> trips) {
		super();
		CustomerId = customerid;
		Mobile = mobile;
		Password = password;
		this.trips = trips;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}