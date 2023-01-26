package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Driver
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DriverId;
	
	private String Mobile;
	
	private String Password;
	
	@OneToOne
	@JoinColumn
	private Cab cab;
	
	@OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
	private List<TripBooking> TripBookingList;

	public int getDriverId() {
		return DriverId;
	}

	public void setDriverId(int driverId) {
		DriverId = driverId;
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

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public List<TripBooking> getTripBookingList() {
		return TripBookingList;
	}

	public void setTripBookingList(List<TripBooking> booking) {
		this.TripBookingList = booking;
	}

	public Driver(int driverId, String mobile, String password, Cab cab, List<TripBooking> booking) {
		super();
		DriverId = driverId;
		Mobile = mobile;
		Password = password;
		this.cab = cab;
		this.TripBookingList = booking;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}