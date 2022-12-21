package com.Celestial.Details_Update;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.celestial.genericLibrary.FIleLibrary;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.WebDriverLibrary;
import com.celestial.objectRepository.AdminHomePage;
import com.celestial.objectRepository.Edit_UpdatePage;
import com.celestial.objectRepository.LoginPage;
import com.celestial.objectRepository.WelcomePage;

public class EditDetails {

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
		AdminHomePage homepage=new AdminHomePage(driver);
		homepage.clickOnDetailsTab();
		Edit_UpdatePage editupdate=new Edit_UpdatePage(driver);
		editupdate.editButton();
		String fullname="dhruva";
		editupdate.cilckOnFullName(fullname);
		editupdate.clickOnOther("ok");                      
		editupdate.clickOnSubmit();
		String title = driver.getTitle();
		if(title.equals("App"))
		{
			System.out.println("successfully updated");
		}
		else {
			System.out.println("not updated");
		}
		login.logoutAction();
		filelib.closePropertyFile();
		driver.close();
	}
}
