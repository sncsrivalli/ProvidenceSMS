package abhiPOMpages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS.genericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS.genericUtility.WebDriverUtility;

public class ClassroomPage {
	@FindBy(xpath = "//span[text()='Classroom']")
	private WebElement classRoom;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement classroomName;
	@FindBy(id = "student_count")
	private WebElement sCount;
	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	
	@FindBy(xpath = "//div[@id='example1_paginate']")
	private WebElement scroll;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr")
	private List<WebElement> table1; 
	
	@FindBy(xpath = "//table[@id='example1']/tbody/tr[ last()]/td[2]")
	private WebElement coloumn;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr[last()]/td[3]")
	private WebElement coloumn1;
	
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement deleteBtn;
	@FindBy(id = "btnYes")
	private WebElement yesBtn;
	

	public ClassroomPage(WebDriver driver) {
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

	public Map<String, String> addClassroom(WebDriverUtility webdriver, ExcelUtility excelUtility) {

		Map<String, String> map = excelUtility.getDataFromExcelFile("Classroom", "Classroom ");
		classRoom.click();
		classroomName.sendKeys(map.get("classroom name"));
		sCount.sendKeys(map.get("student count "));
		submitBtn.click();
		search.sendKeys(map.get("classroom name"));
		return map;
	}
	
	public WebElement scrollSubjectAction() {
		return scroll;
	}
	public List<WebElement> table1SubjectAction() {
		return table1;
	}


	public WebElement coloumnSubjectAction1() {
		return coloumn;
	}
	public WebElement coloumnSubjectAction2() {
		return coloumn1;
	}
	
	public void deleteClassroomAction() {
		deleteBtn.click();
		yesBtn.click();
	}

}
