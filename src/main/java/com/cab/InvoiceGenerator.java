package com.cab;

import java.util.List;

import com.cab.Ride.RideType;

public class InvoiceGenerator {

	private final double NORMAL_MINIMUM_FARE = 5.0;
	private final double NORMAL_COST_PER_KM = 10.0;
	private final int NORMAL_COST_PER_MIN = 1;

	private final double PREMIUM_MINIMUM_FARE = 20.0;
	private final double PREMIUM_COST_PER_KM = 15.0;
	private final int PREMIUM_COST_PER_MIN = 2;

	/**
	 * Method to find the fare for a single ride
	 * @param distance - distance covered by the ride
	 * @param time - time taken to complete the ride
	 * @return - returns the total fare for the ride
	 */
	public double calculateFare(double distance, int time, RideType type) {
		if(type == RideType.NORMAL) {
			double fare = (distance * NORMAL_COST_PER_KM + time * NORMAL_COST_PER_MIN);
			return fare > NORMAL_MINIMUM_FARE ? fare : NORMAL_MINIMUM_FARE;
		} else {
			double fare = (distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MIN);
			return fare > PREMIUM_MINIMUM_FARE ? fare : PREMIUM_MINIMUM_FARE;
		}
	}

	/**
	 * Method to find total fare for multiple rides
	 * @param rides - Array of ride
	 * @return - returns total fare of all rides
	 */
	public double calculateMultipleRide(List<Ride> rides) {
		double totalFare = 0;

		for(Ride ride: rides) {
			totalFare += calculateFare(ride.distance,ride.time, ride.type);
		}
		return totalFare;
	}

	/**
	 * Method to generate the invoice for list of rides
	 * @param rides - List of rides
	 * @return - invoice of all the rides from the list
	 */
	public Invoice getInvoice(List<Ride> rides) {
		double totalFare = 0;
		totalFare = calculateMultipleRide(rides);
		Invoice invoice = new Invoice(rides.size(), totalFare);
		return invoice;
	}


}
