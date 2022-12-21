package com.vtiger.organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.celestial.genericLibrary.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUp {

	public static void main(String[] args) {
		String reqMonth="April";
		String reqYear="2022";
		String reqDay="20";
		WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://rmgtestingserver:8888/index.php?module=Calendar&action=index");
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	   // driver.findElement(By.xpath("//td[@style='padding-right:0px;padding-left:10px;']//img[@alt='Open Calendar...']")).click();
	  
	    String currentMonthYear = driver.findElement(By.xpath("//a[@class='hdrLink']/../..//td[@style='padding-right:0px;padding-left:10px;']//a")).getText();
	    String currentMonth=currentMonthYear.split(" ")[0];
	    String currentYear=currentMonthYear.split(" ")[1];
	    System.out.println(currentMonth);
	    System.out.println(currentYear);
   	   WebDriverWait  wait=new  WebDriverWait(driver, 10);
   //  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear))) {
	    driver.findElement(By.xpath("//img[@src-'themes/images/small_right.gif']")).click();
	   wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calldr']//b"),currentMonthYear));
	    currentMonthYear = driver.findElement (By.xpath("//td[@class='calAdr']//b")).getText();
	    currentMonth=currentMonthYear.split(" ")[0]; 
	    currentYear=currentMonthYear.split(" ")[1];
	    }
	    driver.findElement(By.xpath("//a[text()='"+reqDay+"']")).click();
	} 

}
