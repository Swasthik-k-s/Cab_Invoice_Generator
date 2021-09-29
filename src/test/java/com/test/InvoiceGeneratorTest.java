package com.test;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.cab.Invoice;
import com.cab.InvoiceGenerator;
import com.cab.Ride;
import com.cab.Ride.RideType;
import com.cab.RideRepository;

import junit.framework.Assert;

public class InvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTimeReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 4.0;
		int time = 6;
		double fare = invoiceGenerator.calculateFare(distance, time, RideType.NORMAL);
		Assert.assertEquals(46.0, fare);
	}

	@Test
	public void conditionWhereTotalFareIsLessThanMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.2;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time, RideType.NORMAL);
		Assert.assertEquals(5.0, fare);
	}

	@Test
	public void givenMultipleRidesReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 3.0, 6, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 9.0, 15, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 0.3, 1, RideType.NORMAL));

		double fare = invoiceGenerator.calculateMultipleRide(rideRepository.getRides());
		Assert.assertEquals(146.0, fare);
	}

	@Test
	public void checkInvoiceToPrintTheInvoiceOfMultipleRides() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 3.0, 6, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 9.0, 15, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 0.3, 1, RideType.NORMAL));

		Invoice invoice = invoiceGenerator.getInvoice(rideRepository.getRides());
		Invoice result = new Invoice(3, 146.0);
		Assert.assertEquals(invoice.getNoOfRides(), result.getNoOfRides());
		Assert.assertEquals(invoice.getTotalFare(), result.getTotalFare());
		Assert.assertEquals(invoice.getAvgFare(), result.getAvgFare());
	}

	@Test
	public void checkInvoiceByCalculatingTotalFareUsingRideId() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 3.5, 5, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 7, 12, RideType.NORMAL));
		rideRepository.addRide(new Ride(2, 2, 5, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 0.2, 1, RideType.NORMAL));
		rideRepository.addRide(new Ride(2, 5, 8, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 10, 15, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 4, 6, RideType.NORMAL));

		Invoice rider1 = new Invoice(5, 288.0);
		Invoice rider2 = new Invoice(2, 83.0);

		List<Ride> user1List = rideRepository.getRides().stream().filter(ride -> ride.getId() == 1)
				.collect(Collectors.toList());
		List<Ride> user2List = rideRepository.getRides().stream().filter(ride -> ride.getId() == 2)
				.collect(Collectors.toList());

		Invoice invoice1 = invoiceGenerator.getInvoice(user1List);
		Invoice invoice2 = invoiceGenerator.getInvoice(user2List);

		Assert.assertEquals(rider1.getNoOfRides(), invoice1.getNoOfRides());
		Assert.assertEquals(rider1.getTotalFare(), invoice1.getTotalFare());
		Assert.assertEquals(rider1.getAvgFare(), invoice1.getAvgFare());

		Assert.assertEquals(rider2.getNoOfRides(), invoice2.getNoOfRides());
		Assert.assertEquals(rider2.getTotalFare(), invoice2.getTotalFare());
		Assert.assertEquals(rider2.getAvgFare(), invoice2.getAvgFare());
	}

	@Test
	public void checkPremiumRidesAndNormalRidesTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		RideRepository rideRepository = new RideRepository();

		rideRepository.addRide(new Ride(1, 3.5, 5, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 7, 12, RideType.PREMIUM));
		rideRepository.addRide(new Ride(1, 0.2, 1, RideType.NORMAL));
		rideRepository.addRide(new Ride(1, 10, 15, RideType.PREMIUM));
		rideRepository.addRide(new Ride(1, 1, 2, RideType.PREMIUM));

		Invoice expectedInvoice = new Invoice(5, 374.0);
		Invoice actualInvoice = invoiceGenerator.getInvoice(rideRepository.getRides());

		Assert.assertEquals(expectedInvoice.getNoOfRides(), actualInvoice.getNoOfRides());
		Assert.assertEquals(expectedInvoice.getTotalFare(), actualInvoice.getTotalFare());
		Assert.assertEquals(expectedInvoice.getAvgFare(), actualInvoice.getAvgFare());
	}
}
