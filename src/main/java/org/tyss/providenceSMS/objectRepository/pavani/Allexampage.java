package org.tyss.providenceSMS.objectRepository.pavani;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allexampage {
	@FindBy(xpath="//a[.='Add ']")
	private WebElement addPlusButton;
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameTextField;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitButton;
	@FindBy(xpath="//table[@id='example1']/thead/tr/th")
	private List<WebElement> headerList;
	@FindBy(xpath="//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]")
	private List<WebElement> nameList;
	
	@FindBy(xpath="//a[.='Next']")
	private WebElement nextButton;
	@FindBy (xpath="//div[@id='example1_paginate']/descendant::li[last()-1]/a")
	private WebElement numberOfTimesNextButtonClick;

	
	public Allexampage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//business Library
	public void addButtonClick()
	{
		addPlusButton.click();
	}
	public void addExam(String examName)
	{
		nameTextField.sendKeys(examName);
		submitButton.click();
		
	}
	public List<WebElement> getHeaderList() {
		return headerList;
	}
	public List<WebElement> getNameList() {
		return nameList;
	}
public void nextbuttonClick()
{
	nextButton.click();
}
public WebElement nextbutton()
{
	return nextButton;
}
public WebElement numberOfTimesNextButtonClick()
{
	return numberOfTimesNextButtonClick;
}
	

}

