package com.test;

import org.junit.Test;

import com.cab.InvoiceGenerator;

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
}
