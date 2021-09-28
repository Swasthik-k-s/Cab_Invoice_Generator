package com.cab;

public class InvoiceGenerator {

	private final double MINIMUM_FARE = 5.0;
	private final double COST_PER_KM = 10.0;
	private final int COST_PER_MIN = 1;
	
	/**
	 * Method to find the fare for a single ride
	 * @param distance - distance covered by the ride
	 * @param time - time taken to complete the ride
	 * @return - returns the total fare for the ride
	 */
	public double calculateFare(double distance, int time) {
		double fare = (distance * COST_PER_KM + time * COST_PER_MIN);
		return fare > MINIMUM_FARE ? fare : MINIMUM_FARE;
	}
	
	/**
	 * Method to find total fare for multiple rides
	 * @param rides - Array of ride
	 * @return - returns total fare of all rides
	 */
	public double calculateMultipleRide(Ride[] rides) {
		double totalFare = 0;
		
		for(Ride ride: rides) {
			totalFare += calculateFare(ride.distance,ride.time);
		}
		return totalFare;
	}
	
	public Invoice getInvoice(Ride[] rides) {
		double totalFare = 0;
		totalFare = calculateMultipleRide(rides);
		Invoice invoice = new Invoice(rides.length, totalFare);
		return invoice;
	}
}
