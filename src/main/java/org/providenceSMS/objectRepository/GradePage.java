package org.providenceSMS.objectRepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;
import org.tyss.providenceSMS.genericUtility.JavaUtility;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class GradePage {

	@FindBy(xpath = "//span[text()='Grade']")
	private WebElement grade;

	@FindBy(id = "name")
	private WebElement gradeName;
	@FindBy(id = "admission_fee")
	private WebElement admissionFee;
	@FindBy(id = "hall_charge")
	private WebElement hallCharge;
	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;
	@FindBy(id = "mark_range_text_1")
	private WebElement range;
	@FindBy(id = "mark_grade_text_1")
	private WebElement gradeChar;
	@FindBy(id = "btnSubmit1")
	private WebElement submitBtn1;
	
	@FindBy(xpath = "//div[@id='example1_paginate']")
	private WebElement scroll;
	
	@FindBy(xpath = "//table[@id='example1']/tbody/tr[ last()]/td[2]")
	private WebElement coloumn;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr[last()]/td[3]")
	private WebElement coloumn1;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr[last()]/td[4]")
	private WebElement coloumn2;
	
	@FindBy(xpath = "//table[@id='example1']/tbody/tr")
	private List<WebElement> table1;
	@FindBy(xpath = "//div[@class='navbar-custom-menu']/descendant::li[@class='dropdown user user-menu']")
	private WebElement scroll1;
	
	
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement deleteBtn;
	@FindBy(id = "btnYes")
	private WebElement yesBtn;

	public GradePage(WebDriver driver) {
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

	public String addGrade(WebDriverUtility webdriver, ExcelUtility excelUtility, JavaUtility javaUtility) {

		Map<String, String> map = excelUtility.getDataFromExcelFile("Grade", "Grade ");
		grade.click();
		String name =  map.get("entername")+javaUtility.getRandomNumber(1000);
		gradeName.sendKeys(name);
		admissionFee.sendKeys(map.get("admissionfee"));
		hallCharge.sendKeys(map.get("hallcharge"));
		submitBtn.click();
		range.sendKeys(map.get("eMarks"));
		gradeChar.sendKeys(map.get("grade"));
		submitBtn1.click();
		return name;

	}
//	public void scrollSubjectAction(JavaScriptUtility jsu, WebDriver driver) {
//		jsu.scrollTillElementUsingJSE(scroll,driver);
//	}
	public WebElement scroll() {
		return scroll;
	}
	
	public WebElement scroll1SubjectAction() {
		return scroll1;
	}
	
	public WebElement coloumnSubjectAction1() {
		return coloumn;
	}
	public WebElement coloumnSubjectAction2() {
		return coloumn1;
	}
	public WebElement coloumnSubjectAction3() {
		return coloumn2;
	}
	public List<WebElement> table1SubjectAction() {
		return table1;
	}

//	public void deleteGradeAction() {
//		deleteBtn.click();
//		yesBtn.click();
//	}
}
