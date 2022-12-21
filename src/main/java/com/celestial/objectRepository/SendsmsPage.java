package com.celestial.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is send  class
 * @author Dell
 *
 */
public class SendsmsPage {
	    @FindBy(xpath = "//a[text()='Send SMS']") private WebElement sendSms;
		@FindBy(xpath   = "//form//tbody/child::tr//td[contains(text(),'Sumanth')]/..//input[@type=\"checkbox\"]")  private WebElement listOfUsers;
		@FindBy(xpath  = "//input[@name='message']")  private WebElement message;
		@FindBy(xpath  = "//button[@type='submit']")	     private WebElement submit;
		public SendsmsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public void sendSmsData(String Message) {
			sendSms.click();
			listOfUsers.click();
			message.sendKeys(Message);
			submit.click();
		}
}
