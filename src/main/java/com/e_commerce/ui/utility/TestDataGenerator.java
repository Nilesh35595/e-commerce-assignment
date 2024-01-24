package com.e_commerce.ui.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class TestDataGenerator {

	private static String generateRandomString(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}
	
	private static String generateRandomNumber(int count) {
		return RandomStringUtils.randomNumeric(count);
	}
	
	public static List<String> generateBillingAddressDetails() {
		List<String> details = new ArrayList<String>();
		details.add(generateRandomString(6));
		details.add(generateRandomString(6));
		details.add(generateRandomString(6)+"@yopmail.com");
		details.add("India");
		details.add(generateRandomString(5));
		details.add(generateRandomString(6)+","+details.add(generateRandomString(4))+"details.add(generateRandomString(5))");
		details.add(generateRandomNumber(6));
		details.add(generateRandomNumber(10));
		return details;
	}
}
