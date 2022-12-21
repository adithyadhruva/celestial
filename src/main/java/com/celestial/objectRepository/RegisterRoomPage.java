package com.celestial.objectRepository;

import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.celestial.genericLibrary.WebDriverLibrary;
/**
 * this is register class
 * @author Dell
 *
 */
public class RegisterRoomPage {
	
	private WebDriver driver;
	WebDriverLibrary wb=new WebDriverLibrary();   
	@FindBy(xpath = "//a[text()='Individual Home Registration']") private  WebElement individualRegister;
	 @FindBy(xpath = "//input[@id='fullname']") private WebElement fullName;
	 @FindBy(xpath = "//input[@id='fullname']/../../../div[2]//input[@id='mobile']") private WebElement mobileNo;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//label[text()='Email']/following-sibling::input[@id='email']") private WebElement emailID;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//label[text()='Plot Number/Home Number']/following-sibling::input[@id='plot_number']") private WebElement plotNo;
	 @FindBy(xpath = "//input[@id='rooms']") private WebElement rooms;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//label[text()='Country']/following-sibling::input[@id='country']") private WebElement country;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//label[text()='State']/following-sibling::input[@id='state']") private WebElement state;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//label[text()='City']/following-sibling::input[@id='city']") private WebElement city;
	 @FindBy(xpath = "//input[@id='rent']") private WebElement rent;
	 @FindBy(xpath = "//input[@id='deposit']") private WebElement deposit;
	 @FindBy(xpath = "//input[@id='accommodation']") private WebElement accommodation;
	 @FindBy(xpath = "//input[@id='description']") private WebElement description;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//input[@id='landmark']") private WebElement landmark;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//input[@id='address']") private  WebElement  address;
	 @FindBy(xpath = "//select[@id='vacant']") private WebElement vacant;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//input[@id='image']") private WebElement file;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//button[text()='Submit']") private WebElement submitButton;
	 @FindBy(xpath = "//h2[text()='Register Room']/..//div[text()='Registration successfull. Thank you']") private WebElement confirmationmessage;
	 public RegisterRoomPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 public void clickOnIndividualRegister() {
		 individualRegister.click();
	 }
	 public void registerData(String fullname,String mobileno,String emailid,String plotno,String room,String Country,String State,
			 String City, String Rent,String Deposit,String Accommodation,String Dscription,String Landmark,String  Address ,String text,String File) {
		 fullName.sendKeys(fullname);
		 mobileNo.sendKeys(mobileno);
		 emailID.sendKeys(emailid);
		 plotNo.sendKeys(plotno);
		 rooms.sendKeys(room);
		 country.sendKeys(Country);
		 state.sendKeys(State);
		 city.sendKeys(City);
		 rent.sendKeys(Rent);
		 deposit.sendKeys(Deposit);
		 accommodation.sendKeys(Accommodation);
		 description.sendKeys(Dscription);
		 landmark.sendKeys(Landmark);
		 address.sendKeys(Address);
		 wb.select(vacant, text);
		 file.sendKeys(File);
		 
	 }
	 public void clickOnSubmit() {
		 submitButton.click();
	 }
	 public void confirmationMessage() {
		String text= confirmationmessage.getText();
		System.out.println(text);
	 }
}
