package com.Celestial.register;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.celestial.genericLibrary.ExcelLibrary;
import com.celestial.genericLibrary.FIleLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.SheetName;
import com.celestial.genericLibrary.WebDriverLibrary;
import com.celestial.objectRepository.AdminHomePage;
import com.celestial.objectRepository.LoginPage;
import com.celestial.objectRepository.RegisterRoomPage;
import com.celestial.objectRepository.WelcomePage;

public class RegisterRoomTest {

	public static void main(String[] args) throws IOException {

		FIleLibrary filelib=new FIleLibrary();
		String browser = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.BROWSER.getKey());
		String url = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.getKey());
		String username = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey());
		String password = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());

		ExcelLibrary excelLib=new ExcelLibrary();	
		String fullname=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,0);
		String mobileNo=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,1);
		String EmailD=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,2);
		String plotno=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,3);
		String Rooms=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,4);
		String Country=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,5);
		String State=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,6);
		String City=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,7);
		String Rent=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,8);
		String Deposit=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,9);
		String Accommodation=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,10);
		String description=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,11);
		String Landmark=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,12);
		String Address=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,13);
		WebDriverLibrary webdriverlibrary =new WebDriverLibrary();
		WebDriver driver = webdriverlibrary.launchApplication(browser, url );
		LoginPage login=new LoginPage(driver);
		driver.get(url);
		WelcomePage welcompage=new WelcomePage(driver);
		welcompage.clickOnLogin();
		login.loginAction(username, password);
		RegisterRoomPage rg=new RegisterRoomPage(driver);
		String vacany="Occupied";
		String file = webdriverlibrary.file("./src/test/resources/Screenshot (2).png");
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.clickOnRegisterTab();
	    rg.registerData(fullname, mobileNo, EmailD, plotno, Rooms, Country, State, City, Rent, Deposit, Accommodation, description, Landmark, Address,vacany,file);
		rg.confirmationMessage();
		login.logoutAction();
		filelib.closePropertyFile();
		excelLib.closeExcel();
		driver.close();   
	}
}
