package com.cab;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
	List<Ride> rides;
	
	public RideRepository() {
		rides = new ArrayList<Ride>();
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}
	
	public void addRide(Ride ride) {
		rides.add(ride);
	}
}
