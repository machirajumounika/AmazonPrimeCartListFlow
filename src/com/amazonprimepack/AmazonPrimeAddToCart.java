package com.amazonprimepack;

import javax.swing.JOptionPane;

public class AmazonPrimeAddToCart {

	public static void main(String[] args) {
		TestAmazonCartList testAmazonCartList = new TestAmazonCartList();
		testAmazonCartList.start();
		JOptionPane.showMessageDialog(null, "Output - " + "Created list is displayed");
		System.exit(0);
		
	}

}