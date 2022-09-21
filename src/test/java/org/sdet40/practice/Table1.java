package org.sdet40.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("email")).sendKeys("abhi@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("btnSubmit")).click();
		
		driver.findElement(By.xpath("//span[text()='Teacher']")).click();
		driver.findElement(By.xpath("//a[@href='all_teacher.php']")).click();
		WebElement entries = driver.findElement(By.name("example1_length"));
		Select entryDD = new Select(entries);
		entryDD.selectByVisibleText("50");
		Thread.sleep(2000);
		 
		List<WebElement> teacherList = driver.findElements(By.xpath("//table[@id='example1']/descendant::th"));
		List<WebElement> teacherNameList = new ArrayList<WebElement>();
		Thread.sleep(2000);
		for(int i=0;i<teacherList.size();i++) {
			String headerName =teacherList.get(i).getText();
			if(headerName.equals("Name")) {
				teacherNameList = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr/td["+(i+1)+"]"));
				break;
				
			}
		}
	
		for(WebElement teacherName: teacherNameList) {
			System.out.println(teacherName.getText());
		}
		
		driver.close();

	}

}
