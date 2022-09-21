package org.providenceSMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.SubTabNames;
import org.tyss.providenceSMS.genericUtility.TabNames;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class CommonPage {
	
	//Declaration of all web elements of common page
	//WebDriver driver;
	@FindBy(xpath = "//li[@class='dropdown user user-menu']/a/span") private WebElement usernameIcon;
	@FindBy(xpath = "//a[text()='Sign out']") private WebElement signOutButton;
	private String dynamicPathTab = "//span[text()='%s']";
	private String dynamicPathSubTab = "//a[text()='%s']";
	@FindBy(id="email") private WebElement userNameTextField;
	@FindBy(id="password") private WebElement passwordTextField;
	@FindBy(id="btnSubmit") private WebElement submitButton;
		
		
	// Initialization of all web elements of common page
	
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Business Library

	public void loginAction(String userName,String password) {
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		submitButton.click();
	}
	
	public void clickRequiredTab(WebDriverUtility webDriverUtility,TabNames tabName) {
	
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicPathTab, tabName.getTabName()).click();
	}
	
	public void clickRequiredSubTab(WebDriverUtility webDriverUtility,SubTabNames subTabName) {
		
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicPathSubTab, subTabName.getSubTabName()).click();
	}
	
	public void signOutAction() {
		usernameIcon.click();
		signOutButton.click();
	}
}
