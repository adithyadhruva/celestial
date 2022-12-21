package com.Celestial.register;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_apartmentregistration_test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties property=new Properties();
		property.load(fis);
		String url=property.getProperty("url");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		FileInputStream fisx=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fisx); 
		String Apartmentname=wb.getSheet("ApartmentRegister").getRow(1).getCell(0).toString();
		String mobileNo=wb.getSheet("ApartmentRegister").getRow(1).getCell(1).toString();
		String EmailD=wb.getSheet("ApartmentRegister").getRow(1).getCell(2).toString();
		String plotno=wb.getSheet("ApartmentRegister").getRow(1).getCell(3).toString();
		String Country=wb.getSheet("ApartmentRegister").getRow(1).getCell(4).toString();
		String State=wb.getSheet("ApartmentRegister").getRow(1).getCell(5).toString();
		String City=wb.getSheet("ApartmentRegister").getRow(1).getCell(6).toString();
		String Landmark=wb.getSheet("ApartmentRegister").getRow(1).getCell(7).toString();
		String Address=wb.getSheet("ApartmentRegister").getRow(1).getCell(8).toString();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
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
		File f=new File("./src/test/resources/Screenshot (2).png");
		String file = f.getAbsolutePath();
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//input[@id='image']")).sendKeys(file);
		driver.findElement(By.xpath("//h2[text()='Apartment Room']/..//button[text()='Submit']")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Register Room']/..//div[text()='Registration successfull. Thank you']")).getText();
        System.out.println(text);
	}

}
