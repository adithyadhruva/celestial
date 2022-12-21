package com.celestial.genericLibrary;


import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this is WebDriver library  class
 * @author Dell
 *
 */
public class WebDriverLibrary {
private WebDriver driver;
	/**
	 * this method is to launch the browser
	 * @param browser
	 * @param url
	 * @return
	 */
	public WebDriver launchApplication(String browser,String url) {

		if(browser.equals("chrome")) 
		
		{ 
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	/**
	 *  used to select the value from the dropdown based on value/Option available in GUI
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver,String screenshotName ) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+".png");
		Files.copy(src, dest);
	}	
	/**
	 * This method is to get file from the resource
	 * @param src
	 * @return
	 */
	public String file(String src ) {
		File f=new File(src);
		String file = f.getAbsolutePath();
		return file;
	}
	/**
	 * This method is used to back the webpage
	 */
	public void pageBack() {
		driver.navigate().back();
	}

}


