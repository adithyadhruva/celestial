package com.sql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFIle {

	public static void main(String[] args) throws IOException {
		//step1---->create object for file input stream --->covert from physical file into java readable objecT
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		//step2---->create object for properties
		Properties property=new Properties(); 
		//step3---->load all keys
		property.load(fis);
		//step4---->fetch data from property file
		System.out.println(property.getProperty("browser"));
		System.out.println(property.getProperty("username"));
		System.out.println(property.getProperty("password"));
		fis.close();
	}

}
