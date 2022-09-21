package org.providenceSMS.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class AddSubjectRoutingPage {
	
	@FindBy(id = "day") private WebElement dayDropdown;
	@FindBy(name = "subject_id") private WebElement subjectDropdown;
	@FindBy(id = "classroom") private WebElement classroomDropdown;
	@FindBy(id = "start_time") private WebElement startTimeTextField;
	@FindBy(id = "end_time") private WebElement endTimeTextField;
	@FindBy(xpath = "//button[.='Submit']") private WebElement submitButton;
	
	public AddSubjectRoutingPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	public Map<String, String> addSubjectRouting(WebDriverUtility webdriver,ExcelUtility excel) {
		
		Map<String,String> map = excel.getDataFromExcelFile("TestData", "Add new Exam Timetable");
		webdriver.dropdownByText(dayDropdown, map.get("Day"));
		webdriver.dropdownByIndex(subjectDropdown, Integer.parseInt(map.get("Subject")));
		webdriver.dropdownByText(classroomDropdown, map.get("Classroom"));
		startTimeTextField.sendKeys(map.get("Start Time"));
		endTimeTextField.sendKeys(map.get("End Time"));
		submitButton.click();
		return map;
		
	}


}
