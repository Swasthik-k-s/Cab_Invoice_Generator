package com.cab;

public class InvoiceGenerator {

	private final double MINIMUM_FARE = 5.0;
	private final double COST_PER_KM = 10.0;
	private final int COST_PER_MIN = 1;
	
	public double calculateFare(double distance, int time) {
		double fare = (distance * COST_PER_KM + time * COST_PER_MIN);
		return fare > MINIMUM_FARE ? fare : MINIMUM_FARE;
	}
	
}
