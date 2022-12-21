package com.sql;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisx=new FileInputStream("./src/test/resources/testdata.xlsx");
	
	Workbook wb = WorkbookFactory.create(fisx); 
wb.getSheet("RegisterModule").createRow(4).createCell(0).setCellValue("dhruva");
FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
wb.write(fos);
wb.close();
	}
}
