package com.Celestial.SendSMS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sendsms_test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties property=new Properties();
		property.load(fis);
		String url=property.getProperty("url");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//a[text()='Send SMS']")).click();
		driver.findElement(By.xpath("//h2[text()='List Of Usres']/..//input[@value='8867941398']")).click();
		driver.findElement(By.xpath("//input[@name='message']")).sendKeys("house plot 44/5 is vacant");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
        
	}

}
