package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cab
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int PerKmRate;
	
	private Boolean Available;
	
	@OneToOne(mappedBy = "cab" ,cascade =CascadeType.ALL)
	private Driver driver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPerKmRate() {
		return PerKmRate;
	}

	public void setPerKmRate(int perKmRate) {
		PerKmRate = perKmRate;
	}

	public Boolean getAvailable() {
		return Available;
	}

	public void setAvailable(Boolean available) {
		Available = available;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Cab(int id, int perKmRate, Boolean available, Driver driver) {
		super();
		this.id = id;
		PerKmRate = perKmRate;
		Available = available;
		this.driver = driver;
	}

	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}