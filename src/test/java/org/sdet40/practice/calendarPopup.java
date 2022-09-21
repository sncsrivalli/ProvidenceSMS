package org.sdet40.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarPopup {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String requiredDate="28";
		String requiredMonth="October";
		String requiredYear="2022";
		
		driver.findElement(By.id("datepicker")).click();
		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] str=actualMonthYear.split(" ");
		String actualMonth=str[0];
		String actualYear=str[1];
		
		while(!(actualMonth.equals(requiredMonth) && actualYear.equals(requiredYear))) {
			driver.findElement(By.xpath("//span[.='Next']")).click();
		 actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		str=actualMonthYear.split(" ");
			 actualMonth=str[0];
			actualYear=str[1];
			
		}
		driver.findElement(By.xpath("//a[.='"+requiredDate+"']")).click();
		
		//driver.close();

	}

}
