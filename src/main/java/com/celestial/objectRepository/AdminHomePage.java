package com.celestial.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is  home class
 * @author Dell
 *
 */
public class AdminHomePage {
   @FindBy(xpath  = "//a[text()='Register']") private WebElement registerTab;
   @FindBy(xpath  = "//a[text()='Details/Update']") private WebElement detailsTab;
   @FindBy(xpath  = "//a[text()='Send SMS']") private WebElement sendSMSTab;
   @FindBy(xpath = "//a[text()='Complaint List']") private WebElement complaintTab;
   public AdminHomePage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
   public void clickOnRegisterTab() {
	   registerTab.click();
   }
   public void clickOnDetailsTab() {
	   detailsTab.click();
   }
   public void clickOnSendSmsTab() {
	   sendSMSTab.click();
   }
   public void clickOnComplaintTab() {
	   complaintTab.click();
   }
}
