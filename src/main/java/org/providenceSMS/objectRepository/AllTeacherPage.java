package org.providenceSMS.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class AllTeacherPage {
	
	//Declaration of web elements of All Teacher Page
	
	@FindBy(name="example1_length") private WebElement entriesDropdown;
	@FindBy(xpath = "//table[@id='example1']/thead/tr/th") private List<WebElement> teacherTableHeaderList;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr/td[2]") private List<WebElement> teacherNameList;
	
	//Initialization of the web elements in All Teacher Page
	public AllTeacherPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	//Business Library

	public void entryDropdown() {
		WebDriverUtility webDriver = new WebDriverUtility();
		webDriver.dropdownByText(entriesDropdown, "50");
	}

	public List<WebElement> getTeacherTableHeaderList() {
		return teacherTableHeaderList;
	}

	public List<WebElement> getTeacherNameList() {
		return teacherNameList;
	}
	
	
}
