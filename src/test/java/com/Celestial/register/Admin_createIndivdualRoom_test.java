package com.Celestial.register;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_createIndivdualRoom_test {

	public static void main(String[] args) throws IOException   {
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties property=new Properties();
		property.load(fis);
		String url=property.getProperty("url");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		FileInputStream fisx=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fisx); 
		String fullname=wb.getSheet("RegisterModule").getRow(2).getCell(0).toString();
		String mobileNo=wb.getSheet("RegisterModule").getRow(2).getCell(1).toString();
		String EmailD=wb.getSheet("RegisterModule").getRow(2).getCell(2).toString();
		String plotno=wb.getSheet("RegisterModule").getRow(2).getCell(3).toString();
		String Rooms=wb.getSheet("RegisterModule").getRow(2).getCell(4).toString();
		String Country=wb.getSheet("RegisterModule").getRow(2).getCell(5).toString();
		String State=wb.getSheet("RegisterModule").getRow(2).getCell(6).toString();
		String City=wb.getSheet("RegisterModule").getRow(2).getCell(7).toString();
		String Rent=wb.getSheet("RegisterModule").getRow(2).getCell(8).toString();
		String Deposit=wb.getSheet("RegisterModule").getRow(2).getCell(9).toString();
		String Accommodation=wb.getSheet("RegisterModule").getRow(2).getCell(10).toString();
		String description=wb.getSheet("RegisterModule").getRow(2).getCell(11).toString();
		String Landmark=wb.getSheet("RegisterModule").getRow(2).getCell(12).toString();
		String Address=wb.getSheet("RegisterModule").getRow(2).getCell(13).toString();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
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
		driver.findElement(By.xpath("(//input[@id='rooms'])")).sendKeys(Rooms);	
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
		Select s=new Select(vac);
		s.selectByVisibleText("Vacant");
		File f=new File("./src/test/resources/Screenshot (2).png");
		String file = f.getAbsolutePath();
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//input[@id='image']")).sendKeys(file);
		driver.findElement(By.xpath("//h2[text()='Register Room']/..//button[text()='Submit']")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Register Room']/..//div[text()='Registration successfull. Thank you']")).getText();
         System.out.println(text);
	}

}
