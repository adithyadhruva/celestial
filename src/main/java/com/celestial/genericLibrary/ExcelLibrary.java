package com.celestial.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains excel reusable methods
 * @author Dell
 *
 */
public class ExcelLibrary {
	private static Workbook workbook;
	private FileInputStream fisExcel;
	/**
	 * This method is used to fetch the data from excel using row and cell index
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws IOException
	*/
	public String getDataFromExcel(String excelPath,String sheetName,int rowNumber,int cellNumber)  {

		try {
			fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}
	/**
	 * This method is used to close the excel
	 */
	public void closeExcel()  {
		try {
			workbook.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			fisExcel.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	/**
	 * This method is used to enter  data to the excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataToExcel(String excelPath, String sheetName,int rowNumber,int cellNumber,String data) throws EncryptedDocumentException, IOException 
	{
		FileInputStream	fisExcel = new FileInputStream(excelPath);
		workbook=WorkbookFactory.create(fisExcel);
		workbook.getSheet( sheetName).createRow(rowNumber).createCell(cellNumber).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
		workbook.write(fos);
		fisExcel.close();

	}


}


