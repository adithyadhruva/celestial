package com.celestial.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.celestial.genericLibrary.WebDriverLibrary;
/**
 * this is edit class
 * @author Dell
 *
 */
public class Edit_UpdatePage {
	WebDriverLibrary webdriverlib=new WebDriverLibrary();
	@FindBy(id = "fullname") private WebElement fullName;
	@FindBy(id = "mobile") private WebElement mobile;
	@FindBy(id = "email") private WebElement email;
	@FindBy(id = "plot_number") private WebElement plotNo;
	@FindBy(id = "rooms") private WebElement rooms;
	@FindBy(id = "country") private WebElement country;
	@FindBy(id = "state") private WebElement state;
	@FindBy(id = "city") private WebElement city;
	@FindBy(id = "rent") private WebElement rent;
	@FindBy(id = "deposit") private WebElement deposit;
	@FindBy(id = "accommodation") private WebElement accommodation;
	@FindBy(id = "description") private WebElement description;
	@FindBy(id = "landmark") private WebElement landmark;
	@FindBy(id = "address") private WebElement address;
	@FindBy(xpath = "//select[@id='vacant']") private WebElement vacant;
	@FindBy(id = "other") private WebElement other;
	@FindBy(xpath = "//button[text()='Submit']") private WebElement submitButton;
    @FindBy(xpath = "//p[text()='dhruva']/../parent::div/parent::div[@class='card-block']/child::a[text()='Edit']") private WebElement editbutton;
	public Edit_UpdatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void cilckOnFullName(String Fullname) {
		fullName.clear();
		fullName.sendKeys(Fullname);
	}
	public void clickOnMObile(String  Mobile) {
		mobile.clear();
		mobile.sendKeys(Mobile);
	}
	public void clickOnEmail(String Email) {
		mobile.clear();
		email.sendKeys(Email);
	}
	public void clickOnPlotNo(String PlotNO) {
		plotNo.clear();
		plotNo.sendKeys(PlotNO);
	}
	public void clickOnRooms(String Rooms) {
		rooms.clear();
		rooms.sendKeys(Rooms);
	}
	public void clickOnCountry(String Country) {
		country.clear();
		country.sendKeys(Country);
	}
	public void clickOnState(String State) {
		state.clear();
		state.sendKeys(State);
	}
	public void clickOnCity(String City) {
		city.clear();
		city.sendKeys(City);
	}
	public void clickOnRent(String Rent) {
		rent.clear();
		rent.sendKeys(Rent);
	}
	public void clickOnDeposit(String Deposit) {
		deposit.clear();
		deposit.sendKeys(Deposit);
	}
	public void clickOnAccommodation(String Accommodation) {
		accommodation.clear();
		accommodation.sendKeys(Accommodation);
	}
	public void clickOnDescription(String Description) {
		description.clear();
		description.sendKeys(Description);
	}
	public void clickOnLandmark(String Landmark) {
		landmark.clear();
		landmark.sendKeys(Landmark);
	}
	public void clickOnAddress(String Address) {
		address.clear();
		address.sendKeys(Address);
	}
	public void clickOnVacancy(String text) {
		webdriverlib.select(vacant, text);
	}
	public void clickOnOther(String Other) {
		other.sendKeys(Other);
	}
	public void clickOnSubmit() {
		submitButton.click();
	}
	public void editButton() {
		editbutton.click();
	}
	
}
