package com.celestial.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/** 
 * This class contains file reusable methods
 * @author Dell
 *
 */
public class FIleLibrary {
	private FileInputStream fis;
	/**
	 * This method is used to fetch data from property file
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String propertyFilePath,String key) throws IOException {
		fis=new FileInputStream(propertyFilePath);
		Properties property=new Properties();
		property.load(fis);
		String value=property.getProperty(key); 
		return value;
	}
	/**
	 * this is to close the property file
	 * @throws IOException
	 */
	public void closePropertyFile() throws IOException {
		fis.close();
	}
}
