package com.testng.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPrractice1 {
@Test(dataProvider="getData")
public void test3(String cityName,int pincode) {
	System.out.println("city Name----->"+ cityName+" pincode---->"+pincode);
	System.out.println();
}
@DataProvider
public Object[][] getData(){
	Object[][] arr=new Object[4][2];
	arr[0][0]="Bangalore";
	arr[0][1]=560058;
	
	arr[1][0]="mandya";
	arr[1][1]=573201;
	
	arr[2][0]="kodagu";
	arr[2][1]=571232;
	
	arr[3][0]="vizag";
	arr[3][1]=530013;
	return arr;
	
}










}
