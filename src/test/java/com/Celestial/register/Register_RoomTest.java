package com.Celestial.register;

import org.testng.annotations.Test;

import com.celestial.genericLibrary.BaseClass;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.SheetName;
import com.celestial.objectRepository.AdminHomePage;
import com.celestial.objectRepository.RegisterRoomPage;

public class Register_RoomTest extends BaseClass {
	@Test
	public void createApartmentModule() throws InterruptedException {
		AdminHomePage adminHomePage=new AdminHomePage(driver);
		adminHomePage.clickOnRegisterTab();
		RegisterRoomPage registerRoomPage=new RegisterRoomPage(driver);
		registerRoomPage.clickOnIndividualRegister();
		String fullname=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,0);
		String mobileNo=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,1);
		String EmailD=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,2);
		String plotno=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,3);
		String Rooms=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,4);
		String Country=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,5);
		String State=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,6);
		String City=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,7);
		String Rent=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,8);
		String Deposit=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,9);
		String Accommodation=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,10);
		String description=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,11);
		String Landmark=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,12);
		String Address=excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.RegisterModule.toString(),4,13);
		String vacany="Occupied";
		String file = webDriverLibrary.file("./src/test/resources/Screenshot (2).png");
		registerRoomPage.registerData(fullname, mobileNo, fullname, plotno, Rooms, Country, State, City, Rent, Deposit, Accommodation, description, Landmark, Address, vacany, file);
		Thread.sleep(3000);
		registerRoomPage.clickOnSubmit();
		
	}
}
