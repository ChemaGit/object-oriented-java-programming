package com.week_1.location;

public class SimpleLocation {
	private double latitude;
	private double longitude;
	
	public SimpleLocation() {
		// UC San Diego
		this.latitude = 32.9;
		this.longitude = -117.2;
	}

	public SimpleLocation(double latIn,double lonIn) {
		this.latitude = latIn;
		this.longitude = lonIn;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(double lat) {
		if(lat < -90 || lat > 90) {
			System.out.println("Illegal value for latitude.");
		} else {
			this.latitude = lat;
		}		
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(double lon) {
		if(lon < -90 || lon > 90) {
			System.out.println("Illegal value for longitude.");
		} else {
			this.longitude = lon;
		}		
	}
// More code here
}
