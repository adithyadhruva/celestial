package com.Celestial.register;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.celestial.genericLibrary.BaseClass;
import com.celestial.genericLibrary.IConstantPath;
import com.celestial.genericLibrary.PropertyFileKeys;
import com.celestial.genericLibrary.SheetName;
import com.celestial.objectRepository.AdminHomePage;
import com.celestial.objectRepository.ApartmentRoomPage;
//@Listeners(com.celestial.genericLibrary.LisImpClass.class)
public class Apartment_RoomTest extends BaseClass {
	@Test
	public void createApartmentModule() throws InterruptedException, IOException {
	
		AdminHomePage adminHomePage=new AdminHomePage(driver);
		adminHomePage.clickOnRegisterTab();
		ApartmentRoomPage ar=new ApartmentRoomPage(driver);
		ar.clickonApartmentRoom();		
         
		String image=fIleLibrary.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, PropertyFileKeys.IMAGE.getKey());
		String Apartmentname = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 0);
		String mobileNo = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 1);
		String EmailD = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 2);
		String plotno = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 3);
		String Country = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 4);
		String State = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 5);
		String City = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 6);
		String Landmark = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 7);
		String Address = excelLibrary.getDataFromExcel(IConstantPath.EXCEL_PATH.toString(),SheetName.ApartmentRegister.toString(), 2, 8);

		String file = webDriverLibrary.file(image);
		ar.apartmentRoomData(Apartmentname, mobileNo, EmailD, plotno, Country, State, City, Landmark, Address,file);	
		Thread.sleep(3000);
		ar.clickOnSubmit();
	   
	}

}
