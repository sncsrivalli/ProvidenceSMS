package org.tyss.providenceSMS.objectRepository.pavani;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSubjectPage {
	@FindBy(xpath="//input[@placeholder='Enter Subject name']")
	private WebElement subjectTextField;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitButton;
	@FindBy(xpath="//div[@class='col-sm-12']/table/thead/tr/th")
	private List<WebElement> headerList;
	@FindBy(xpath="//table[@id='example1']/tbody/tr/td[2]")
	private List<WebElement> subjectList;
	@FindBy(xpath="//a[.='Next']")
	private WebElement nextButton;
	


public CreateSubjectPage(WebDriver driver){
	PageFactory.initElements(driver,this);
	
}
public void sendSubject(String subject)
{
	subjectTextField.sendKeys(subject);
}
public void clickOnSubmit() {
	submitButton.click();
}
public List<WebElement> getHeaderList()
{
	return headerList;
}
public List<WebElement> getSubjectList()
{
	return subjectList; 	
}

public void clickOnNextButton()
{
	nextButton.click();
}
	public WebElement getNextButton()
	{
		return nextButton;
	}
}
