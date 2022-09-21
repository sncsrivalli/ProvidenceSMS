package org.sdet40.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarPopup1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String requiredDate="18";
		String requiredMonth="June";
		String requiredYear="1987";
		
		int requiredMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth).get(ChronoField.MONTH_OF_YEAR);
		int requiredYearInNum = Integer.parseInt(requiredYear);
		
		driver.findElement(By.id("datepicker")).click();
		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] str=actualMonthYear.split(" ");
		String actualMonth=str[0];
		String actualYear=str[1];
		int actualMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		int actualYearInNum= Integer.parseInt(actualYear);
		
		while(actualMonthInNum<requiredMonthInNum || actualYearInNum<requiredYearInNum) {
			driver.findElement(By.xpath("//span[.='Next']")).click();
		 actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		str=actualMonthYear.split(" ");
			 actualMonth=str[0];
			actualYear=str[1];
			actualMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
			actualYearInNum= Integer.parseInt(actualYear);
			
		}
		
		while(actualMonthInNum>requiredMonthInNum || actualYearInNum>requiredYearInNum) {
			driver.findElement(By.xpath("//span[.='Prev']")).click();
		 actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		str=actualMonthYear.split(" ");
			 actualMonth=str[0];
			actualYear=str[1];
			actualMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
			actualYearInNum= Integer.parseInt(actualYear);
			
		}
		driver.findElement(By.xpath("//a[.='"+requiredDate+"']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
