package com.prep;

public class OverridingInPrivateMethods extends PrivateMethodTesting {
	
	private void testingMethod() {
		System.out.println("Overriding Private Method Testing");
	}
	
	public static void main(String[] args) {
		OverridingInPrivateMethods check = new OverridingInPrivateMethods();
		check.testingMethod();
		
		PrivateMethodTesting check2 = new OverridingInPrivateMethods();
		((OverridingInPrivateMethods)check2).testingMethod();
	}

}
