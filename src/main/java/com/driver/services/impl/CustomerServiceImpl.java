package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Cab;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer customer=customerRepository2.findById(customerId).get();
		List<TripBooking> booking=customer.getTrips();
		for(TripBooking bookings : tripBookingRepository2.findAll())
		{
			if(booking.contains(bookings))
			{
				tripBookingRepository2.delete(bookings);
			}
		}
		customerRepository2.delete(customer);
		

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		Driver driver=new Driver();
		for(Driver driver2:driverRepository2.findAll())
		{
			if(driver2.getCab().getAvailable()==true)
			{
				driver=driver2;
				break;
			}
		}
		TripBooking booking=new TripBooking();
		booking.setDistanceInKm(distanceInKm);
		booking.setCustomer(customerRepository2.findById(customerId).get());
		booking.setFromLocation(fromLocation);
		booking.setToLocation(toLocation);
		booking.setStatus(TripStatus.CONFIRMED);
		tripBookingRepository2.save(booking);
		List<TripBooking> bookings=tripBookingRepository2.findAll();
		bookings.add(booking);
		driver.setBooking(bookings);
		driverRepository2.save(driver);
		
		return booking;
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query

	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking booking=tripBookingRepository2.findById(tripId).get();
		booking.setStatus(TripStatus.CANCELED);
		tripBookingRepository2.save(booking);
		

	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking booking=tripBookingRepository2.findById(tripId).get();
		booking.setStatus(TripStatus.COMPLETED);
		tripBookingRepository2.save(booking);

	}
}
