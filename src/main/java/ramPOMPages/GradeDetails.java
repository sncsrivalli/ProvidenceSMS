package ramPOMPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GradeDetails {
	//declaration
	@FindBy(xpath="//span[text()='Grade']") private WebElement gradeTab;
	@FindBy(id="name") private WebElement gradeNameTextfield;
	@FindBy(id="admission_fee") private WebElement admissionFessTextfield;
	@FindBy(id="hall_charge") private WebElement hallChargeTextfield;
	@FindBy(id="btnSubmit") private WebElement nextButon;
	@FindBy(id="mark_range_text_1") private WebElement rangeTextfield;
	@FindBy(id="mark_grade_text_1") private WebElement gradeTextfield;
	@FindBy(id="btnSubmit1") private WebElement submittButton;
	
	
	@FindBy(xpath="//table[@id='example1']/tbody/tr") private WebElement gradelist;
	//@FindBy(xpath="//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[last()]/td[last()]/a[2]") private WebElement deleteButton;
	
	@FindBy(xpath="//a[text()='Delete']") private WebElement deleteButton;//a[.='Delete']  //a[@class='confirm-delete btn btn-danger btn-xs' and text()='Delete']
	@FindBy(xpath="//a[@id='btnYes']") private WebElement yesButton;
	
	@FindBy(xpath="//select[@class='form-control input-sm']") private WebElement entryGradeDropdown;
	
	
	
	//initialization all element variable
	public GradeDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Business library
	public void clickGradeTab() {
		gradeTab.click();
	}
	
	public void addGrade(Map<String, String> map) {
		gradeNameTextfield.sendKeys(map.get("GradeName"));
		admissionFessTextfield.sendKeys(map.get("Admission Fees"));
		hallChargeTextfield.sendKeys(map.get("Hall Charge"));
		nextButon.click();
	}
	
	public void allGrade(Map<String, String> map) {
		rangeTextfield.sendKeys(map.get("Grade Range"));
		gradeTextfield.sendKeys(map.get("Grade"));
		submittButton.click();
		
	}
	
	public void selectIndex() {
		Select s=new Select(entryGradeDropdown);
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
	
	public void deleteGrade() {
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
