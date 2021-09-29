package com.cab;

public class Ride {
	double distance;
	int time;
	int id;
	RideType type;
	
	public enum RideType{
		NORMAL, PREMIUM
	};
	
	public Ride(int id, double distance, int time,RideType type){
		this.id = id;
		this.distance = distance;
		this.time = time;
		this.type = type;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
