package com.Celestial.register;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.celestial.genericLibrary.ExcelLibrary;
import com.celestial.genericLibrary.FIleLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.objectRepository.*;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.SheetName;
import com.celestial.genericLibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIndivdualRoomTest {

	public static void main(String[] args) throws IOException {

		FIleLibrary filelib=new FIleLibrary();
		String browser = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.BROWSER.getKey());
		String url = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.getKey());
		String username = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey());
		String password = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
		String image = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.IMAGE.getKey());
        ExcelLibrary excelLib=new ExcelLibrary();	
		excelLib.setDataToExcel(IConstantPath.EXCEL_PATH.toString(), SheetName.RegisterModule.toString(), 5, 0, "adithya");
		String fullname=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,0);
		String mobileNo=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,1);
		String EmailD=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,2);
		String plotno=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,3);
		String Rooms=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,4);
		String Country=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,5);
		String State=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,6);
		String City=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,7);
		String Rent=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,8);
		String Deposit=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,9);
		String Accommodation=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,10);
		String description=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,11);
		String Landmark=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,12);
		String Address=excelLib.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),3,13);
		WebDriverLibrary webdriverlibrary =new WebDriverLibrary();
	    WebDriver driver = webdriverlibrary.launchApplication(browser, url );
	    LoginPage login=new LoginPage(driver);
		driver.get(url);
	  driver.findElement(By.xpath("//a[text()='Login']")).click();
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
   	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys(fullname);
		driver.findElement(By.xpath("//input[@id='fullname']/../../../div[2]//input[@id='mobile']")).sendKeys(mobileNo);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//label[text()='Email']/following-sibling::input[@id='email']")).sendKeys(EmailD);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//label[text()='Plot Number/Home Number']/following-sibling::input[@id='plot_number']")).sendKeys(plotno);	
		driver.findElement(By.xpath("//input[@id='rooms']")).sendKeys(Rooms);	
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//label[text()='Country']/following-sibling::input[@id='country']")).sendKeys(Country);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//label[text()='State']/following-sibling::input[@id='state']")).sendKeys(State);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//label[text()='City']/following-sibling::input[@id='city']")).sendKeys(City);
		driver.findElement(By.xpath("//input[@id='rent']")).sendKeys(Rent);	
		driver.findElement(By.xpath("//input[@id='deposit']")).sendKeys(Deposit);
		driver.findElement(By.xpath("//input[@id='accommodation']")).sendKeys(Accommodation);
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys(description);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//input[@id='landmark']")).sendKeys(Landmark);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//input[@id='address']")).sendKeys(Address);
		WebElement vac = driver.findElement(By.xpath("//select[@id='vacant']"));
		webdriverlibrary.select(vac,"Vacant");
	    String file = webdriverlibrary.file(image);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//input[@id='image']")).sendKeys(file);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//button[text()='Submit']")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Register Room']/..//div[text()='Registration successfull. Thank you']")).getText();
		System.out.println(text);
		filelib.closePropertyFile();
		excelLib.closeExcel();
		driver.close();	
	}
}
