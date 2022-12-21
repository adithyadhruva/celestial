
package com.Celestial.SendSMS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.celestial.genericLibrary.FIleLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.WebDriverLibrary;
import com.celestial.objectRepository.LoginPage;
import com.celestial.objectRepository.SendsmsPage;
import com.celestial.objectRepository.WelcomePage;

public class SendSTest {

	public static void main(String[] args) throws IOException {
		FIleLibrary filelib=new FIleLibrary();
		String browser = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.BROWSER.getKey());
		String url=filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.URL.getKey());
		String username = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.USERNAME.getKey() );
		String password = filelib.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,PropertyFileKeys.PASSWORD.getKey());
		WebDriverLibrary webdriverlibrary =new WebDriverLibrary();
		WebDriver driver = webdriverlibrary.launchApplication(browser, url);
		driver.get(url);
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.clickOnLogin();
		LoginPage login=new LoginPage(driver);
		login.loginAction(username, password);
		SendsmsPage   sendSms=new SendsmsPage(driver);
		sendSms.sendSmsData("good morning");
		webdriverlibrary.pageBack();
		login.logoutAction();
		filelib.closePropertyFile();
		driver.close();
	}
}
		
	