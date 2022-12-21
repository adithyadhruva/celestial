package com.celestial.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is apartment room class
 * @author Dell
 *
 */
public class ApartmentRoomPage {
	 @FindBy(xpath = "//a[text()='Apartment Registration']") private WebElement apartmentReg;
	 @FindBy(xpath = "//input[@id='apartment_name']") private WebElement apartmentName;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//label[text()='Mobile']/following-sibling::input[@id='mobile']") private WebElement mobileNo;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//label[text()='Email']/following-sibling::input[@id='email']") private WebElement emailID;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//label[text()='Plot Number/Home Number']/following-sibling::input[@id='plot_number']") private WebElement plotNo;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//label[text()='Country']/following-sibling::input[@id='country']") private WebElement country;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//label[text()='State']/following-sibling::input[@id='state']") private WebElement state;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//label[text()='City']/following-sibling::input[@id='city']") private WebElement city;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//input[@id='landmark']") private WebElement landmark;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//input[@id='address']") private WebElement address;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//input[@id='image']") private WebElement file;
	 @FindBy(xpath = "//h2[text()='Apartment Room']/..//button[text()='Submit']") private WebElement submitButton;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//div[text()='Registration successfull. Thank you']") private WebElement confirmationMessage;
	public ApartmentRoomPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	public void clickonApartmentRoom() {
		apartmentReg.click();	
	}
	public void enterApartmentname(String ApartmentName) {
		//apartmentName.sendKeys(ApartmentName);
	}
	
	public void apartmentRoomData(String ApartmentName,String MobileNo,String Email,String PlotNo,
			String Country,String State,String City,String Landmark,String Address,String File ) {
		//apartmentReg.click();
		apartmentName.sendKeys(ApartmentName);
		mobileNo.sendKeys(MobileNo);
		emailID.sendKeys(Email);  
		plotNo.sendKeys(PlotNo);
		country.sendKeys(Country);
		state.sendKeys(State);
		city.sendKeys(City);
		landmark.sendKeys(Landmark);
		address.sendKeys(Address);
		file.sendKeys(File);
		
	
		}
	public void clickOnSubmit() {
		submitButton.click();
	}
	public void confirmationMessage() {
		String text=confirmationMessage.getText();
		System.out.println(text);
	}
 }
