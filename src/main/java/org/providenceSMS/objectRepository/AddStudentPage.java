package org.providenceSMS.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.ExcelUtility;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class AddStudentPage {
	
	@FindBy(id = "index_number") private WebElement studentIdTextField;
	@FindBy(id = "full_name") private WebElement studentFullNameTextField;
	@FindBy(id = "i_name") private WebElement studentNameWithInitialsTextField;
	@FindBy(id = "address") private WebElement studentAddressTextField;
	@FindBy(id = "email") private WebElement studentEmailTextField;
	@FindBy(id = "phone") private WebElement studentPhoneTextField;
	@FindBy(id = "b_date") private WebElement studentDOBTextField;
	@FindBy(name = "gender") private WebElement studentGenderDropdown;
	@FindBy(id = "fileToUpload") private WebElement studentPhoto;
	@FindBy(id = "g_full_name") private WebElement parentFullNameTextField;
	@FindBy(id = "g_i_name") private WebElement parentNameWithInitialsTextField;
	@FindBy(id = "g_address") private WebElement parentAddressTextField;
	@FindBy(id = "g_email") private WebElement parentEmailTextField;
	@FindBy(id = "g_phone") private WebElement parentPhoneTextField;
	@FindBy(id = "g_b_date") private WebElement parentDOBTextField;
	@FindBy(name = "g_gender") private WebElement parentGenderDropdown;
	@FindBy(id = "g_fileToUpload") private WebElement parentPhoto;
	@FindBy(id = "btnSubmit") private WebElement submitButton;
	@FindBy(id = "grade") private WebElement gradeDropdown;
	private Map<String,String> map ;
	
	public AddStudentPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public Map<String, String> addNewStudent(WebDriverUtility webdriver, ExcelUtility excel) {
		map = excel.getDataFromExcelFile("TestData","Add new Student account");
		studentIdTextField.sendKeys(map.get("Index Number"));
		studentFullNameTextField.sendKeys(map.get("Student Full Name"));
		studentNameWithInitialsTextField.sendKeys(map.get("Student Name with Initials"));
		studentAddressTextField.sendKeys(map.get("Student Address"));
		studentEmailTextField.sendKeys(map.get("Student Email"));
		studentPhoneTextField.sendKeys(map.get("Student Phone"));
		studentDOBTextField.sendKeys(map.get("Student Birth Date"));
		webdriver.dropdownByText(studentGenderDropdown, map.get("Student Gender"));
		studentPhoto.sendKeys(map.get("Student Photo"));
		parentFullNameTextField.sendKeys(map.get("Parent Full Name"));
		parentNameWithInitialsTextField.sendKeys(map.get("Parent Name with Initials"));
		parentAddressTextField.sendKeys(map.get("Parent Address"));
		parentEmailTextField.sendKeys(map.get("Parent Email"));
		parentPhoneTextField.sendKeys(map.get("Parent Phone"));
		parentDOBTextField.sendKeys(map.get("Parent Birth Date"));
		webdriver.dropdownByText(parentGenderDropdown, map.get("Parent Gender"));
		parentPhoto.sendKeys(map.get("Parent Photo"));
		submitButton.click();
		return map;
		
	}
	
	public void selectGradeFromDropdown(WebDriverUtility webdriver, ExcelUtility excel) {
		webdriver.dropdownByText(gradeDropdown, map.get("Grade"));
	}

}
