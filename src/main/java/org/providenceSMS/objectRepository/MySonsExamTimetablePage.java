package org.providenceSMS.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class MySonsExamTimetablePage {
	
	//Declaration
	@FindBy(id="exam") private WebElement examDropdown;
	@FindBy(xpath = "//button[.='Submit']") private WebElement submitButton;

	//Initialization
	public MySonsExamTimetablePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Business Library
	public void selectFromExamDropdown (WebDriverUtility webdriver,Map<String,String> map) {
		webdriver.dropdownByText(examDropdown,map.get("Exam"));
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
}
