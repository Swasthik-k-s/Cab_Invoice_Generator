package com.test;

import org.junit.Test;

import com.cab.Invoice;
import com.cab.InvoiceGenerator;
import com.cab.Ride;

import junit.framework.Assert;

public class InvoiceGeneratorTest {
	
	@Test
	public void givenDistanceAndTimeReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 4.0;
		int time = 6;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(46.0, fare);
	}
	
	@Test
	public void conditionWhereTotalFareIsLessThanMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.2;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5.0, fare);
	}
	
	@Test
	public void givenMultipleRidesReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(3.0, 6), new Ride(9.0, 15), new Ride(0.3, 1) };
		double fare = invoiceGenerator.calculateMultipleRide(rides);
		Assert.assertEquals(146.0, fare);
	}
	
	@Test
	public void checkInvoiceToPrintTheInvoiceOfMultipleRides() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(3.0, 6), new Ride(9.0, 15), new Ride(0.3, 1) };
		Invoice invoice = invoiceGenerator.getInvoice(rides);
		Invoice result = new Invoice(3, 146.0);
		Assert.assertEquals(invoice, result);
	}
}
