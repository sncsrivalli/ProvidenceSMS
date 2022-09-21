package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
//import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[.='KIDS']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		WebElement item = driver.findElement(By.xpath("//div[.='AARIKA GIRLS ETHNIC']"));
		WebElement price= driver.findElement(By.xpath("//div[.='AARIKA GIRLS ETHNIC']/parent::div[@class='contentHolder']/descendant::span[@class='price  ']"));
		String ReqItem = item.getText();
		String priceValue=price.getText();
		System.out.println(priceValue);
		System.out.println(ReqItem);
		driver.quit();
		FileInputStream fis = new FileInputStream("./src/test/resources/Ajio.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Kids");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(ReqItem);
		
		Cell cell1 = row.createCell(1);
		cell1.setCellValue(priceValue);
		
		wb.write(new FileOutputStream("./src/test/resources/Ajio.xlsx"));
		
		wb.close();
	}

}
