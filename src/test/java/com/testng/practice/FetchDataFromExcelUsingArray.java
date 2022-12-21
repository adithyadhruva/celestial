package com.testng.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingArray {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		 Sheet sheet = workbook.getSheet("RegisterModule");
		int lastRowNUmber=sheet.getLastRowNum();
		short lastCellNumber=sheet.getRow(2).getLastCellNum();
		String[][] arr=new String[lastRowNUmber][lastCellNumber];
		for(int i=0;i<lastRowNUmber;i++) {
			for(int j=0;j<lastCellNumber;j++) {
				arr[i][j]=sheet.getRow(i+1).getCell(j).toString();			
		}
	}
        for(int i=0;i<arr.length;i++) {
        	  
			for(int j=0;j <arr[i].length;j++) {
				System.out.println(arr[i][j]);
        		 
        	 }
        	
        }
}
}