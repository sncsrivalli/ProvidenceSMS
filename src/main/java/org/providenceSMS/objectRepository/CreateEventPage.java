package org.providenceSMS.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class CreateEventPage {
	
	@FindBy(xpath = "//a[@class='btn btn-sm  bg-orange-active pull-right ']") 
	private WebElement createEventButton;
	
	@FindBy(id = "title") private WebElement eventNameTextField;
	@FindBy(id = "category") private WebElement categoryDropdown;
	@FindBy(id ="reservationtime") private WebElement eventTimeTextField;
	
	public CreateEventPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickCreateEventButton() {
		createEventButton.click();
	}
	
	public Map<String, String> createEvent(WebDriverUtility webdriver, ExcelUtility excel) {
		Map<String,String> map = excel.getDataFromExcelFile("TestData", "Add new Event");
		eventNameTextField.sendKeys(map.get("Event Title"));
		webdriver.dropdownByText(categoryDropdown, map.get("Category"));
		return map;
	}

}
