package com.week_2;

import com.week_1.location.SimpleLocation;

public class Scope {

	public static void main(String[] args) {
		double latitude = -15.5;
		SimpleLocation lima = new SimpleLocation(latitude, -77);
		latitude = -12.0;
		System.out.println(lima.getLatitude());
	}
}
