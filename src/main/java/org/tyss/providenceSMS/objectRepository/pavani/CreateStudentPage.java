package org.tyss.providenceSMS.objectRepository.pavani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateStudentPage {
	private WebDriver driver;
		@FindBy(xpath="//input[@id='index_number']")
private WebElement indexNumberTextField;
	@FindBy(xpath="//input[@id='full_name']")
	private WebElement fullNameTextField;
	@FindBy(xpath="//input[@id='i_name']")
	private WebElement nameWithIntialsTextfield;
	@FindBy(xpath="//input[@id='address']")
	private WebElement addressTextField;
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextField;
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNumberTextfield;
	@FindBy(xpath="//input[@id='b_date']")
	private WebElement dateOfBirthTextField;
	@FindBy(xpath="//select[@id='gender']")
	private WebElement genderDropdown;
	@FindBy(xpath="//input[@id='fileToUpload']")
	private WebElement photoUpload;
	@FindBy(xpath="//input[@id='g_index']")
	private WebElement g_indexNumberTextField;
	@FindBy(xpath="//input[@name='g_full_name']")
	private WebElement g_fullNameTextField;
	@FindBy(xpath="//input[@id='g_i_name']")
	private WebElement g_nameWithIntialsTextfield;
	@FindBy(xpath="//input[@name='g_address']")
	private WebElement g_addressTextField;
	@FindBy(xpath="//input[@name='g_email']")
	private WebElement g_emailTextField;
	@FindBy(xpath="//input[@id='g_phone']")
	private WebElement g_phoneNumberTextfield;
	@FindBy(xpath="//input[@id='g_b_date']")
	private WebElement g_dateOfBirthTextField;
	@FindBy(xpath="//select[@name='g_gender']")
	private WebElement g_genderDropdown;
	@FindBy(xpath="//input[@id='g_fileToUpload']")
	private WebElement g_photoUpload;
	@FindBy(xpath="//button[.='Next']")
	private WebElement nextButton;
	@FindBy(xpath="//select[@id='grade']")
	private WebElement gradeDropdown;
	@FindBy(xpath="//table/thead/tr/th")
	private List<WebElement> headerList;
	@FindBy(xpath="//table[@class='table ']/tbody/tr/td[2]")
	private List<WebElement> subjectList;
	@FindBy(xpath="//tbody/descendant::td[.='Subject 6']/parent::tr/td/input[@type='checkbox']")
	private WebElement subjectCheckbox;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitButton;
@FindBy(xpath="//button[@class='close  ']")
protected WebElement closeIcon;

@FindBy(xpath="//a[.=' All Student']")
private WebElement allStudentButton;
@FindBy(xpath="//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]")
private List<WebElement> nameList;
@FindBy(xpath="//a[.='Next']")
private WebElement nextButtonInAllStudent;
@FindBy (xpath="//div[@id='example1_paginate']/descendant::li[last()-1]/a")
private WebElement numberOfTimesNextButtonClick;


String validation="//a[@data-dt-idx='%s']";
public CreateStudentPage(WebDriver driver)
{
PageFactory.initElements(driver,this);
this.driver=driver;
}
/**
 * 
 * @param indexnumber
 * @param fullname
 * @param namewithinitals
 * @param address
 * @param email
 * @param phonenumber
 * @param dateofbirth
 * @param gender
 * @param photoPath
 */
public void enterStudentDetails(int indexnumber,String fullname,String namewithinitals,String address,String email,String phonenumber,String dateofbirth,String gender,String photoPath)

{
	indexNumberTextField.sendKeys(""+indexnumber);
	fullNameTextField.sendKeys(fullname);
	nameWithIntialsTextfield.sendKeys(namewithinitals);
	addressTextField.sendKeys(address);
	emailTextField.sendKeys(email);
	phoneNumberTextfield.sendKeys(""+phonenumber);
	dateOfBirthTextField.sendKeys(dateofbirth);
	Select s=new Select(genderDropdown);
	s.selectByVisibleText(gender);
	photoUpload.sendKeys(photoPath);
	
	
	
	
}
public void enterGurdianDetails(int g_indexnumber,String g_fullname,String g_namewithinitals,String g_address,String g_email,String g_phonenumber,String g_dateofbirth,String g_gender,String g_photoPath)

{
	g_indexNumberTextField.sendKeys(""+g_indexnumber);
	g_fullNameTextField.sendKeys(g_fullname);
	g_nameWithIntialsTextfield.sendKeys(g_namewithinitals);
	g_addressTextField.sendKeys(g_address);
	g_emailTextField.sendKeys(g_email);
	g_phoneNumberTextfield.sendKeys(""+g_phonenumber);
	g_dateOfBirthTextField.sendKeys(g_dateofbirth);
	Select s=new Select(g_genderDropdown);
	s.selectByVisibleText(g_gender);
	g_photoUpload.sendKeys(g_photoPath);
	//nextButton.click();
	
	
	
	
}
public void selectGrade(String grade) 
{
	Select s=new Select(gradeDropdown);
	s.selectByVisibleText(grade);

}
public void selectSubject()
{
	
	subjectCheckbox.click();
	
	
}

public List<WebElement> getSubjectList() {
	
return subjectList;
	
}
public List<WebElement> getHeaderList() {
	
return headerList;
}
public List<WebElement> getNameList() {
	
return nameList;
}
public void validatingStudentDetails()
{
}
public void clickSubmitButton()
{
	submitButton.click();
}
public void clickCloseIcon(WebDriver driver) {
//{ Actions act = new Actions(driver);
//act.moveToElement(closeIcon).perform();	
	closeIcon.click();
}
	
public void nextButton()
{
	nextButton.click();
	
}
public void nextButtonInAllStudent()
{
	nextButtonInAllStudent.click();
	
}
	
public WebElement validationDynamic(String req)
{
	String act = String.format(validation, req);
	WebElement s = driver.findElement(By.xpath(act));
	return s;
}
public WebElement numberOfTimesNextButtonClick()
{
	return numberOfTimesNextButtonClick;
}
	
}
