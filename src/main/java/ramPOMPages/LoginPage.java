package ramPOMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//*******************declaration*********************
	/*
	 * Admin login
	 */
	@FindBy(id="email") private WebElement emailTextField;
	@FindBy(id="password") private WebElement passwordTextField;
	@FindBy(id="btnSubmit") private WebElement submittButton;
	
	/*
	 * Teacher login
	 */
	@FindBy(id="email") private WebElement teacherEmailTextField;
	@FindBy(id="password") private WebElement teacherPasswordTextField;
	@FindBy(id="btnSubmit") private WebElement teacherSubmittButton;
	
	
	//**************initialization all element variable***************************
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//*******************Business library********************************
	/*
	 * Admin login utilization
	 */
	public void loginAction(String email,String password) {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		submittButton.click();
		
	}
	
	/*
	 * Teacher login utilization
	 */
	public void teacherLoginAction(String temail,String tpassword) {
		teacherEmailTextField.sendKeys(temail);
		teacherPasswordTextField.sendKeys(tpassword);
		teacherSubmittButton.click();
		
	}
	
	

}
