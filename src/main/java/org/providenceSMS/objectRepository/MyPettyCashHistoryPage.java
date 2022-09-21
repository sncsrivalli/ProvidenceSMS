package org.providenceSMS.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class MyPettyCashHistoryPage {
	
	@FindBy(xpath = "//a[.='Add ']") private WebElement addButton;
	@FindBy(xpath = "//input[@id='textDesc_1']") private WebElement descriptionTextField;
	@FindBy(id = "textAmount_1") private WebElement amountTextField;
	@FindBy(id = "btnSubmit") private WebElement submitButton;
	
	public MyPettyCashHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickAddButton() {
		addButton.click();
	}
	
	public Map<String, String> addPettyCash(WebDriverUtility webdriver,ExcelUtility excel) {
		Map<String,String> map = excel.getDataFromExcelFile("TestData", "Add Petty Cash ");
		descriptionTextField.sendKeys(map.get("Description"));
		amountTextField.sendKeys(map.get("Amount"));
		submitButton.click();
		return map;
	}
	

}
