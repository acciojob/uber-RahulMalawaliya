package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TripBooking
{
	
	private static int TripBookid = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int TripBookingId;
	
	private String fromLocation;
	
	private String ToLocation;
	
	private int DistanceInKm;
	
	@Enumerated
	private TripStatus status;
	
	private int bill;
	
	@ManyToOne
	@JoinColumn
	private Driver driver;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;

	public static int getTripBookid() {
		return TripBookid;
	}

	public static void setTripBookid(int tripBookid) {
		TripBookid = tripBookid;
	}

	public int getTripBookingId() {
		return TripBookingId;
	}

	public void setTripBookingId(int tripBookingId) {
		TripBookingId = tripBookingId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return ToLocation;
	}

	public void setToLocation(String toLocation) {
		ToLocation = toLocation;
	}

	public int getDistanceinKm() {
		return DistanceInKm;
	}

	public void setDistanceinKm(int distanceinKm) {
		DistanceInKm = distanceinKm;
	}

	public TripStatus getStatus() {
		return status;
	}

	public void setStatus(TripStatus status) {
		this.status = status;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public TripBooking(int tripBookingId, String fromLocation, String toLocation, int distanceinKm, TripStatus status,
			int bill, Driver driver, Customer customer) {
		super();
		TripBookingId = tripBookingId;
		this.fromLocation = fromLocation;
		ToLocation = toLocation;
		DistanceInKm = distanceinKm;
		this.status = status;
		this.bill = bill;
		this.driver = driver;
		this.customer = customer;
	}

	public TripBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}