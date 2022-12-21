package com.celestial.genericLibrary;

import java.io.IOException;

import org.apache.bcel.generic.L2D;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.celestial.objectRepository.AdminHomePage;
import com.celestial.objectRepository.ApartmentRoomPage;
import com.celestial.objectRepository.LoginPage;
import com.celestial.objectRepository.RegisterRoomPage;
import com.celestial.objectRepository.WelcomePage;

public class BaseClass {
	protected ExcelLibrary excelLibrary;
	protected FIleLibrary fIleLibrary;
	protected WebDriverLibrary webDriverLibrary;
    protected WebDriver driver;
	protected LoginPage loginPage;
	protected WelcomePage  welcomePage;
	protected AdminHomePage adminHomePage;
	protected  ApartmentRoomPage apartmentRoom;
	protected RegisterRoomPage registerRoomPage;
	protected PropertyFileKeys propertyFileKeys;
	protected String username;
	protected String password;
	protected String url;
	
	protected static String browser;
	@BeforeClass
	public void classSetup() throws IOException {
		excelLibrary=new ExcelLibrary();
		fIleLibrary=new FIleLibrary();
		webDriverLibrary=new WebDriverLibrary();
		browser = fIleLibrary.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.BROWSER.getKey());
		url=fIleLibrary.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.URL.getKey());
	    driver= webDriverLibrary.launchApplication("chrome", url);
        driver.get(url);
		loginPage=new LoginPage(driver);
		welcomePage=new WelcomePage(driver);
		welcomePage.clickOnLogin();	
				
	}
	@BeforeMethod
	public void methodSetup() throws IOException {
		String username = fIleLibrary.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey());
		String password = fIleLibrary.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
		loginPage.loginAction(username, password);
		
	}
	@AfterMethod
	public void methodTearDown() throws InterruptedException {
		Thread.sleep(3000);
		loginPage.logoutAction();
	}
	@AfterClass
	public void classTearDown() throws IOException {
		fIleLibrary.closePropertyFile();
		excelLibrary.closeExcel();
		driver.close();
	}
}
