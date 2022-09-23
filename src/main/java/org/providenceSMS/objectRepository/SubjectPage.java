package org.providenceSMS.objectRepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;


public class SubjectPage {

	@FindBy(xpath = "//span[text()='Subject']")
	private WebElement subject;

	@FindBy(id = "name")
	private WebElement subjectName;
	@FindBy(id = "//button[text()='Submit']")
	private WebElement submitBtn;
	@FindBy(name = "example1_length")
	private WebElement dropdown;
	@FindBy(xpath = "//a[text()='Next']")
	private WebElement next;
	@FindBy(xpath = "//table[@id='example1']/thead/tr/th\"")
	private List<WebElement> table1;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr/td[2]")
	private List<WebElement> table2;
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement deleteBtn;
	@FindBy(id = "btnYes")
	private WebElement yesBtn;

	public SubjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Business Library
	/**
	 * This method is used to get data from excel by giving key as input
	 * 
	 * @param webdriver
	 * @param excelUtility
	 * @return
	 */

	public Map<String, String> addSubject(WebDriverUtility webdriver, ExcelUtility excelUtility) {

		Map<String, String> map = excelUtility.getDataFromExcelFile("Subject", "Subject");
		subject.click();
		subjectName.sendKeys(map.get("entername"));
		submitBtn.click();
		return map;
	}
	
	public WebElement dropdownSubjectAction() {
		return dropdown;
	}
	
	public WebElement nextSubjectAction() {
		return next;
	}
	public List<WebElement> table1SubjectAction() {
		return table1;
	}
	public List<WebElement> table2SubjectAction() {
		return table2;
	}
	
	public void deleteSubjectAction() {
		deleteBtn.click();
		yesBtn.click();
	}

}
