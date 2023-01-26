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
	private List<TripBooking> TripBookings;

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
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

	public List<TripBooking> getTripBookings() {
		return TripBookings;
	}

	public void setTripBookings(List<TripBooking> trips) {
		this.TripBookings = trips;
	}

	public Customer(int customerId, String mobile, String password, List<TripBooking> trips) {
		super();
		CustomerId = customerId;
		Mobile = mobile;
		Password = password;
		this.TripBookings = trips;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}