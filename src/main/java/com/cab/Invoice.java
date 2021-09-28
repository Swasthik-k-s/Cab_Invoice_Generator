package com.cab;

public class Invoice {
	private final int noOfRides;
	private final double totalFare;
	private final double avgFare;
	
	public Invoice(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.avgFare = this.totalFare / this.noOfRides;
	}
}
