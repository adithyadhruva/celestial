package com.Celestial.SendSMS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.celestial.genericLibrary.ExcelLibrary;
import com.celestial.genericLibrary.FIleLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.WebDriverLibrary;

public class SendSMStest {

	public static void main(String[] args) throws IOException {
		FIleLibrary filelib=new FIleLibrary();
		String browser = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.BROWSER.getKey());
		String url=filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.getKey());
		String username = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey() );
		String password = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
		WebDriverLibrary webdriverlibrary =new WebDriverLibrary();
		WebDriver driver = webdriverlibrary.launchApplication(browser, url);
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//a[text()='Send SMS']")).click();
		driver.findElement(By.xpath("//form//tbody/child::tr//td[contains(text(),'Sumanth')]/..//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@name='message']")).sendKeys("house plot 44/5 is vacant");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		filelib.closePropertyFile();
		driver.close();	
	}

}
