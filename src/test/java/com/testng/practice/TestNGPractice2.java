package com.testng.practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;



public class TestNGPractice2 {

	@Test(groups= {"sanity" ,"firefox"})
	public void test() {
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(10, 10);
		Reporter.log("Test before",true);
		softAssert.assertAll();
		Reporter.log("Test After ",true);		
	}
	
	@Parameters(value = {"browser","username"})
	@Test(groups = "sanity")
	public void test2(String browser,String username) {
		Reporter.log("test 2----> browser name---->"+ browser, true);
		Reporter.log("test 2----> username---->"+ username, true);
	}
	
	@Parameters("url")
	@Test(groups = "reg")
	public void test1(String url) {
		Reporter.log("test 1", true);
		Reporter.log("test 2-----> url name--->" + url, true);
	}
}
