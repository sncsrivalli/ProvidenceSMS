package org.tyss.providenceSMS.objectRepository.pavani;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateGradePage {
	@FindBy (id="name")
	private WebElement gradeTextField;
	@FindBy(xpath="//input[@placeholder='Enter admission fee']")
	private WebElement admissionfeeTextField;
	@FindBy(xpath="//input[@id='hall_charge']")
	private WebElement hallChargeTextField;
	@FindBy(xpath="//button[.='Next']")
	private WebElement nextButton;
	@FindBy(id="mark_range_text_1")
	private WebElement rangeTextField;
	@FindBy(name="mark_grade[]")
	private WebElement gradesTextField;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitButton;
	@FindBy(xpath="//table[@id='example1']/thead/tr/th")
	private List<WebElement> headerList;
	@FindBy(xpath="//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]")
	private List<WebElement> gradeList;
	@FindBy(xpath="//a[.='Next']")
	private WebElement nextButtonInAllGrade;
	@FindBy (xpath="//div[@id='example1_paginate']/descendant::li[last()-1]/a")
	private WebElement numberOfTimesNextButtonClick;
	


public CreateGradePage(WebDriver driver) {
	
	PageFactory.initElements(driver,this);
}
 public void createGrade(String grade,int admissionfee,int hallcharge) {
	 gradeTextField.sendKeys(grade);
	 admissionfeeTextField.sendKeys(""+admissionfee);
	 hallChargeTextField.sendKeys(""+hallcharge);
	 nextButton.click();
	 
	 
 }
public void sendRangeAndGrade(String range,String grade)
{ rangeTextField.sendKeys(range);
gradesTextField.sendKeys(grade);
submitButton.click();
}
public List<WebElement> getHeaderList() {
	return headerList;
}
public List<WebElement> getGradeList()
{
	return gradeList;
}

public void clickNextButtonInAllGrade()
{
	nextButtonInAllGrade.click();
}
public WebElement numberOfTimesNextButtonClick()
{
	return numberOfTimesNextButtonClick;
}
public WebElement NextButtonInAllGrade()
{
	return nextButtonInAllGrade;
}
}




