package com.testng.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.celestial.genericLibrary.ExcelLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.SheetName;

public class TestNGDataProviderPractice2 {

	 @Test(dataProvider="getData")
	 public void test3(String UserName,String password) {
		 System.out.println("Username--->"+UserName+"Password--->"+password);
		 System.out.println();
	 }
	 @DataProvider
	 public String getData() {
		 ExcelLibrary excelLibrary=new ExcelLibrary();
		 
		String arr= excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(), SheetName.RegisterModule.toString(), 3, 1);
		 
		return arr;
		 
	 }
}
