package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("CommonData");
		//Row row = sheet.getRow(7);
		//Cell cell1 = row.getCell(5);
		Row row1 = sheet.createRow(6);
		Cell cell = row1.createCell(3);
		cell.setCellValue("d4");
		wb.write(new FileOutputStream("./src/test/resources/TestData.xlsx"));
		System.out.println("Data Updated Successfully");
		wb.close();
	}

}
