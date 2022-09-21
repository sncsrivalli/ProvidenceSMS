package ramPOMPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExamDetails {
	//declaration
		@FindBy(xpath="//span[.='Exam']") private WebElement examTab;
		@FindBy(xpath="//a[.='Create Exam']") private WebElement createExamTab;
		@FindBy(xpath="//a[.='Add ']") private WebElement addButton;
		
		@FindBy(xpath="//input[@id='name']") private WebElement examNameTextfield;
		@FindBy(xpath="//button[@id='btnSubmit']") private WebElement submitButton;

		@FindBy(xpath="//select[@class='form-control input-sm']") private  WebElement entryDropdown;
		
		@FindBy(xpath="//tr[@role='row']/parent::thead/following-sibling::tbody//tr[last()]//a[@class='confirm-delete btn btn-danger btn-xs']") private WebElement deleteButton;
		@FindBy(xpath="//a[@id='btnYes']") private WebElement yesButton;
		
		
		
		
		//initialization all element variable
		public ExamDetails(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//Business library
		public void clickExamTab() {
			examTab.click();
			createExamTab.click();
			addButton.click();
		}
		
		public void addExam(Map<String, String> map) {
			examNameTextfield.sendKeys(map.get("Exam Name"));
			submitButton.click();
		}
		
		public void selectIndex() {
			Select s=new Select(entryDropdown);
			s.selectByIndex(3);
			
			
		}
		public void waitTillElementisClickable(WebElement ele) throws InterruptedException
		{
			int count=0;
			while(count<10)
			{
				try
				{
					ele.click();
					break;
				}
				catch(Exception e)
				{
					Thread.sleep(500);
					count++;
				}
			}
		}
		
		public WebElement getEle()
		{
		return deleteButton;	
		}
		
		public void deleteExam() {
			deleteButton.click();
			
		}
		
	    public WebElement getyes()
	    {
	      return yesButton;	
	     }
	    
	     public void yesbut() {
		  yesButton.click();

	     }
}
