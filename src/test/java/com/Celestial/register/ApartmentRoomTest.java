package com.Celestial.register;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.celestial.genericLibrary.BaseClass;
import com.celestial.genericLibrary.ExcelLibrary;
import com.celestial.genericLibrary.FIleLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.SheetName;
import com.celestial.genericLibrary.WebDriverLibrary;
import com.celestial.objectRepository.AdminHomePage;
import com.celestial.objectRepository.ApartmentRoomPage;
import com.celestial.objectRepository.LoginPage;
import com.celestial.objectRepository.WelcomePage;

public class ApartmentRoomTest  {

	public static void main(String[] args) throws IOException {
	FIleLibrary filelib=new FIleLibrary();
		String url=filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.getKey());
		String browser = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.BROWSER.getKey());
		String username = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey());
		String password = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
		String image=filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.IMAGE.getKey());
		ExcelLibrary excelLib=new ExcelLibrary();  
		String Apartmentname = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 0);
		String mobileNo = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 1);
		String EmailD = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 2);
		String plotno = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 3);
		String Country = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 4);
		String State = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 5);
		String City = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 6);
		String Landmark = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 7);
		String Address = excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 8);
		WebDriverLibrary webdriverlibrary =new WebDriverLibrary();
		WebDriver driver = webdriverlibrary.launchApplication(browser, url);
		driver.get(url);
		
		WelcomePage welcomepage=new WelcomePage(driver);
		welcomepage.clickOnLogin();
		LoginPage login=new LoginPage(driver);
		login.loginAction(username, password);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.clickOnRegisterTab();
		ApartmentRoomPage ar=new ApartmentRoomPage(driver);
		ar.clickonApartmentRoom();
		String file = webdriverlibrary.file(image);
		ar.apartmentRoomData(Apartmentname, mobileNo, EmailD, plotno, Country, State, City, Landmark, Address, file);
		ar.clickOnSubmit();
		
		filelib.closePropertyFile();
   	    excelLib.closeExcel(); 
		driver.close();	
		
		}
}
