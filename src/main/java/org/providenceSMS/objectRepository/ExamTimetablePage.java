package org.providenceSMS.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExamTimetablePage {
	
	@FindBy(xpath = "//a[.='Add ']") private WebElement addButton;
	@FindBy(xpath = "//table/thead/tr/th") private List<WebElement> examTimetableHeaderList;
	@FindBy(xpath = "//table/tbody/tr/td") private List<WebElement> examTimetableList;
	
	public ExamTimetablePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickAddButton() {
		addButton.click();
	}

	public List<WebElement> getExamTimetableHeaderList() {
		return examTimetableHeaderList;
	}

	public List<WebElement> getExamTimetableList() {
		return examTimetableList;
	}

}
