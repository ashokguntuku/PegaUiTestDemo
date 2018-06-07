package com.pega.qa.Util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class randomUtil {
	/**
	 * Generates a random string of characters
	 * 
	 * @param rng
	 * @param length
	 * @return
	 */

	private static SecureRandom random = new SecureRandom();

	public static String generateRandomString(int length) {
		String result = new BigInteger(Long.SIZE * length, random).toString(32);
		return result.substring(0, length);

	}

	/*
	 * Returns a 12 digit number based on the current time. (to get unique
	 * number).
	 */
	public static String getUniqueNumber_dateFormat() {

		try {
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmss");
			String datetime = ft.format(dNow);

			return datetime;
		} catch (Exception ex) {
			System.out.println(ex);
			return new Date().toString();
		}
	}

	public static int getrandomMobileNumber() {
		Random objGenerator = new Random();
		int randomNumber = 0;
		for (int xCount = 0; xCount < 10; xCount++) {
			randomNumber = objGenerator.nextInt(100);
		}
		return randomNumber;
	}

	/**
	 * Generates a random Name
	 * 
	 */
	public static String generateRandomName(int length) {
		return generateRandomString(length);
	}

	/**
	 * Generates a random Email
	 * 
	 * @return
	 */
	public static String generateRandomEmail() {
		return generateRandomString(4) + "@hcl.com";
	}
}
