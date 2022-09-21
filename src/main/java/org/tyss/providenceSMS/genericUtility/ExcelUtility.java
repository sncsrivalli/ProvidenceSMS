package org.tyss.providenceSMS.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of actions on the Excel workbook
 * @author sncsr
 *
 */

public class ExcelUtility {
	private Workbook workbook;
	private FileOutputStream fosExcel;
	/**
	 * This method is used to initialize the workbook
	 * @param excelPath
	 */
	
	public void initializeExcel(String excelPath) {
		FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
		try {
			workbook = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	/**
	 * This method consists of code to fetch data from the Excel workbook
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	
	public String getDataFromExcelFile(String sheetName,int rowNumber, int cellNumber) {

	Sheet sheet = workbook.getSheet(sheetName);
	String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	return data;
	
	}
	
	public Map<String, String> getDataFromExcelFile(String sheetName, String expectedValue) {
		Sheet sheet = workbook.getSheet(sheetName);
		Map<String,String> map = new HashMap<>();
		DataFormatter df = new DataFormatter();
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedValue))
			{
				for(int j=i;j<=sheet.getLastRowNum();j++)
				{
					map.put(df.formatCellValue(sheet.getRow(j).getCell(2)),df.formatCellValue(sheet.getRow(j).getCell(3)));
					if(df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
						break;
				}
				break;
			}
		}
//		for(int i=1; i<=8;i++) {
//			map.put(df.formatCellValue(sheet.getRow(i).getCell(2)), df.formatCellValue(sheet.getRow(i).getCell(3)));
//		}
		return map;
	}
	/**
	 * This method is used to write data to Excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	
//	public void writeToExcel(String sheetName, int rowNumber,int cellNumber, String value) {
//		try {
//			fosExcel= new FileOutputStream(AutoConstant.EXCEL_PATH);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		Sheet sheet = workbook.getSheet(sheetName);
//		Row row = sheet.getRow(rowNumber);
//		Cell cell = row.createCell(cellNumber);
//		cell.setCellValue(value);
//		try {
//			workbook.write(fosExcel);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	public void writeToExcel(String sheetName,String testName,String testResult){
		
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		for(int i=1;i<=sheet.getLastRowNum(); i++)
		{	
				if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(testName))
				{
					try {
						fosExcel = new FileOutputStream(AutoConstant.EXCEL_PATH);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					Cell cell = sheet.getRow(i).getCell(4);
					cell.setCellValue(testResult);
					try {
						workbook.write(fosExcel);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			
		}
	}
	/**
	 * This method is used to close the workbook
	 */
	
	public void closeExcelWorkbook() {
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
