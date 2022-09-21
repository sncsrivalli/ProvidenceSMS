 package org.tyss.providenceSMS.objectRepository.pavani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//Declaration
	
@FindBy(xpath="//input[@id='email']")
private WebElement userNameTextField;
@FindBy(xpath="//input[@name='password']")
private WebElement passwordTextField;
@FindBy(xpath="//button[.='Submit']")
private WebElement submitbutton;
//Initialization all element variable
public Loginpage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
//business Library
public void loginAction(String userName,String password)
{userNameTextField.sendKeys(userName);
passwordTextField.sendKeys(password);
submitbutton.click();
}
}
