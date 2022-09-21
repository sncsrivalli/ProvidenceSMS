package org.providenceSMS.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectsPopUp {
	
	@FindBy(xpath = "//table/thead/tr/th") private List<WebElement> subjectTableHeaderList;
	@FindBy(xpath = "//table[@class='table ']/tbody/tr/td[2]") private List<WebElement> subjectList;
	@FindBy(id = "btnSubmit1") private WebElement submitButton;
	private String dynamicPath ="//tbody/descendant::td[.='%s']/parent::tr/td/input[@type='checkbox']";
	
	public SubjectsPopUp(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public List<WebElement> getSubjectTableHeaderList() {
		return subjectTableHeaderList;
	}

	public List<WebElement> getSubjectList() {
		return subjectList;
	}

	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void clickSubjectCheckbox(String replaceData, WebDriver driver) {
		String requiredPath = String.format(dynamicPath,replaceData);
		WebElement checkbox = driver.findElement(By.xpath(requiredPath));
		checkbox.click();
	}
	
}
