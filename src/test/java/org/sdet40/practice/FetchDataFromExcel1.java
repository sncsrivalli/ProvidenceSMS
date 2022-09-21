package org.sdet40.practice;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		DataFormatter df = new DataFormatter();
		try {
		Sheet sheet = wb.getSheet("CommonData");
		
		Cell cell= sheet.getRow(2).getCell(1);
		String username = df.formatCellValue(cell);
		System.out.println(username);
		}
		finally {
		wb.close();
		}
	}

}
