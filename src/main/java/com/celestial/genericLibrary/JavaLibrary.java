package com.celestial.genericLibrary;

import java.util.Random;
/**
 * this is java utility class
 * @author Dell
 *
 */
public class JavaLibrary {
	/**
	 * this is to get the data for java utility
	 * @param s
	 * @param strategy
	 * @return
	 */
	public Object stringToAnyToAnyDataType(String s,String strategy) {
		Object ConvertedData=null;
		if(strategy.equals("int")) {
			ConvertedData=Integer.parseInt(s);
		}
		else if(strategy.equals("long")) {
			ConvertedData=Long.parseLong(s);

		}
		return ConvertedData;
	}
	/**
	 * this is to get the random number
	 * @param limit
	 * @return
	 */
	public  int getRandomNumber(int limit) {
		int randomNumber=new Random().nextInt(limit);
		return randomNumber;

	}

}