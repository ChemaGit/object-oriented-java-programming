package com.week_2;

public class PrimitiveMemoryModels {
	
	public static void main(String[] args) {
		int var1;
		var1 = 52;
		int var2;
		var2 = var1;
		var1 = 127;
		System.out.println("var1 is " + var1 + ", var2 is " + var2);
		
		int var3 = 17;
		int var4 = var3 + 1;
		var3 = var4 + 1;
		System.out.println("var3 is " + var3 + ", var4 is " + var4);
	}

}
