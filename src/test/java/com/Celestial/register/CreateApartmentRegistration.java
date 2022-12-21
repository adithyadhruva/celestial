package com.Celestial.register;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.celestial.genericLibrary.ExcelLibrary;
import com.celestial.genericLibrary.FIleLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.SheetName;
import com.celestial.genericLibrary.WebDriverLibrary;

public class CreateApartmentRegistration {
public static void main(String[] args) throws IOException, InterruptedException {
		FIleLibrary filelib=new FIleLibrary();
		String browser=filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.BROWSER.getKey());
		String url=filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.getKey());
		String username = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey() );
		String password = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
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
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//a[text()='Apartment Registration']")).click();
		driver.findElement(By.xpath("//input[@id='apartment_name']")).sendKeys(Apartmentname);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//label[text()='Mobile']/following-sibling::input[@id='mobile']")).sendKeys(mobileNo);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//label[text()='Email']/following-sibling::input[@id='email']")).sendKeys(EmailD);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//label[text()='Plot Number/Home Number']/following-sibling::input[@id='plot_number']")).sendKeys(plotno);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//label[text()='Country']/following-sibling::input[@id='country']")).sendKeys(Country);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//label[text()='State']/following-sibling::input[@id='state']")).sendKeys(State);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//label[text()='City']/following-sibling::input[@id='city']")).sendKeys(City);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//input[@id='landmark']")).sendKeys(Landmark);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//input[@id='address']")).sendKeys(Address);
		String file = webdriverlibrary.file("./src/test/resources/Screenshot (2).png");
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//input[@id='image']")).sendKeys(file);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//button[text()='Submit']")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Register Room']/..//div[text()='Registration successfull. Thank you']")).getText();
		System.out.println(text);
		filelib.closePropertyFile();
		excelLib.closeExcel();
		driver.close();
}
}
