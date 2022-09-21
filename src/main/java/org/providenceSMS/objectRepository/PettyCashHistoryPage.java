package org.providenceSMS.objectRepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;

public class PettyCashHistoryPage {
	
	@FindBy(xpath = "//input[@type='search']") private WebElement searchTextField;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr") private List<WebElement> pettyCashHeaderList;
	
	public PettyCashHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void writeToSearchTextField(Map<String,String> map) {
		searchTextField.sendKeys(map.get("Teacher Name"));
	}

	public List<WebElement> getPettyCashHeaderList() {
		return pettyCashHeaderList;
	}
	
	public void approveAndValidatePettyCash(WebDriver driver, Map<String,String> map,ExcelUtility excel) {
		
		int last = pettyCashHeaderList.size();
		
		for(int i = 0;i<last;i++)
		{
			String receivedByName = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			String paidStatus = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[6]")).getText();
			if(receivedByName.equals(map.get("Teacher Name")) && paidStatus.equals("Pending"))
			{
				driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[7]/a[.='Approve']")).click();
				excel.writeToExcel("TestData", "Add Petty Cash ", "Pass");
				System.out.println("TC Pass");
				driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();
				break;
			}
			else if(i == last)
			{
				excel.writeToExcel("TestData", "Add Petty Cash ", "Fail");
				System.out.println("TC Fail");
			}
		}
	}
	
}
