package com.celestial.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is login class
 * @author Dell
 *
 */
public class LoginPage {
	@FindBy(name = "username")  private WebElement userNameTextFeild;
	@FindBy(name = "password")  private WebElement passWordTextFeild;
	@FindBy(name = "login")	     private WebElement loginButton;
	@FindBy(xpath = "//a[text()='Logout']") private WebElement logoutButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public void loginAction(String username,String password) {
    	userNameTextFeild.sendKeys(username);
    	passWordTextFeild.sendKeys(password);
    	loginButton.click();
    }
    public void logoutAction() {
    	logoutButton.click();
    }
}    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 




