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
	
	public int getNoOfRides() {
		return noOfRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public double getAvgFare() {
		return avgFare;
	}

	@Override
	public String toString() {
		return "Invoice [noOfRides=" + noOfRides + ", totalFare=" + totalFare + ", avgFare=" + avgFare + "]";
	}
}
