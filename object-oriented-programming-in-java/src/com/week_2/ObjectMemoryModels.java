package com.week_2;

import com.week_1.location.SimpleLocation;

public class ObjectMemoryModels {
	public static void main(String[] args) {
		SimpleLocation lima = new SimpleLocation(-17, -77);
		lima.setLatitude(-12);
		int var1 = 52;
		
		
		SimpleLocation loc1 = new SimpleLocation(39.9, 116.4);
		SimpleLocation loc2 = new SimpleLocation(55.8, 37.6);
		loc1 = loc2;
		loc1.setLatitude(-8.3);
		System.out.println(loc2.getLatitude() + ", " + loc2.getLongitude());
		
		double d = -77;
		SimpleLocation lima1 = new SimpleLocation(-12, d);
		SimpleLocation washDC = new SimpleLocation(38.9, lima.getLongitude());
		
		SimpleLocation ucsd = new SimpleLocation(39.2, -117.2);
		SimpleLocation kumamoto = new SimpleLocation(32.0, 130.0);
		ucsd = kumamoto;
		kumamoto = ucsd;
		
		System.out.println("UCSD: " + ucsd.getLatitude() + ", " + ucsd.getLongitude());
		System.out.println("Kumamoto: " + kumamoto.getLatitude() + ", " + kumamoto.getLongitude());
	}
}
