package org.providenceSMS.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class AddExamTimetablePage {
	
	//Declaration 
	@FindBy(id = "grade") private WebElement gradeDropdown;
	@FindBy(id ="exam") private WebElement examDropdown;
	@FindBy(xpath = "//button[.='Next']") private WebElement nextButton;
	
	//Initialization
	public AddExamTimetablePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public void addExamTimetable(WebDriverUtility webdriver,ExcelUtility excelUtility) {
			
		Map<String,String> map = excelUtility.getDataFromExcelFile("TestData","Add new Exam Timetable");
		
		webdriver.dropdownByText(gradeDropdown, map.get("Grade"));
		webdriver.dropdownByText(examDropdown, map.get("Exam"));
	}

	public void clickNextButton() {
		nextButton.click();
	}
}
