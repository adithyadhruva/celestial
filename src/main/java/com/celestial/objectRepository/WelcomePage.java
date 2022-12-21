package com.celestial.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is welcome class
 * @author Dell
 *
 */
public class WelcomePage {
	@FindBy(xpath = "//a[text()='Search']") private WebElement searchButton;
	@FindBy(xpath  = "//a[text()='Login']") private WebElement loginButton;
	@FindBy(xpath  = "//a[text()='Register']") private WebElement registerButton;
	@FindBy(xpath = "//a[text()='Logo/Home']")private WebElement logoButton;
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearch() {
		searchButton.click();
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	
	public void clickOnRegister() {
		registerButton.click();
	}
	
	public void clickOnLogo() {
		logoButton.click();
	}
}
