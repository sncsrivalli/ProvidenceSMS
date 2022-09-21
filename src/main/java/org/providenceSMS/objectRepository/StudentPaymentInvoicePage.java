package org.providenceSMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class StudentPaymentInvoicePage {
	
	@FindBy(xpath = "//button[@class='close  ']") private WebElement closeButton;
	
	public StudentPaymentInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickCloseButton(WebDriverUtility webdriver) {
		webdriver.explicitWait(closeButton, 10);
		webdriver.moveToElementAction(closeButton);
		closeButton.click();
	}

}
