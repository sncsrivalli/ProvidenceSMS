package ramPOMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS_GenericUtility.SubTabNames;
import org.tyss.ProvidenceSMS_GenericUtility.TabNames;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class CommonPage {
	
	WebDriver driver;
	//***************declration of all web elements of common page*****************
	/*
	 * Admin signout
	 */
	@FindBy(xpath="//li[@class='dropdown user user-menu']/a/span") private WebElement usernameIcon;//span[text()='Abhishek K H']
	@FindBy(xpath="//a[text()='Sign out']") private WebElement signOutButton;
	
	
	@FindBy(xpath="//h5[text()='Abhishek K H,']/descendant::span[text()=' Welcome back! ']")
	private WebElement msg;
	
	/*
	 * Admin signin (we used in separate loginpage only)
	 */
	@FindBy(id="email") private WebElement userNameTextField;
	@FindBy(id="password") private WebElement passwordTextField;
	@FindBy(id="btnSubmit") private WebElement submitButton;
	
	
	    //@FindBy(xpath="//table[@id='example1']/tbody/tr") private WebElement gradelist;
		//@FindBy(xpath="//a[text()='Previous']") private WebElement previous;
		//@FindBy(xpath="//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[last()]/td[2]") private WebElement gradeLable;
		//@FindBy(xpath="//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[6]/td[2]") private WebElement Grade8;
		
	@FindBy(xpath="//table[@id='example1']/tbody/tr[last()]/td[2]") private WebElement gradetext;//table[@id='example1']/tbody/tr[8]/td[2]   //td[text()='Grade 12']
	@FindBy(xpath="//div[@id='example1_info']") private WebElement Text;
	
	
	//Snout as teacher declaration
		@FindBy(xpath="//span[@class='hidden-xs']") private WebElement teacherNameIcon;
		@FindBy(xpath="//a[.='Sign out']") private WebElement TeacherSignOutButton;
		
		
	/*
	 * Dynamic
	 */
	private String dynamicPathTab="//span[text()='%s']";
	private String dynamicPathSubTab="//a[text()='%s']";
	
	
	/*
	 * pettycash under admin
	 */
	@FindBy(xpath="//span[.='Petty Cash']") private WebElement adminPettyCashTab;
	
	
	
	//********Initialization of all web elements of common page**********
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//***********************business library******************************
	/*
	 * Admin signin utilization (we used in separate loginpage only)
	 */
	public void loginAction(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitButton.click();
	}
	 
	
	public void clickRequiredTab(WebDriverUtility webDriverUtility, TabNames tabName) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicPathTab, tabName.getTabName()).click();
	}
	
	public void clickRequiredSubTab(WebDriverUtility webDriverUtility, SubTabNames tabName) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicPathSubTab, tabName.getSubTabName()).click();
	}
	
	/*
	 * this method is used to sign out as Admin
	 */
	public void signOutAction() {
		usernameIcon.click();
		signOutButton.click();
		System.out.println("Logout is successfull..");
	}
	
	/*
	 * This method is used signout as a teacher
	 */
	public void signOutTeacher() {
		teacherNameIcon.click();
		TeacherSignOutButton.click();
		System.out.println("Logout is successfull..");
		
	}
	
	
	public String getTextAction() {
		return gradetext.getText();
		
	}
	
	public String getMessage() {
		String Message = msg.getText();
		if(Message.equals("Welcome back!"))
		{
			System.out.println("Login is successfull...");
		} else {
			System.out.println("Login is failure");
		}
		return Message;
	}
		
	public void Scroll(WebDriverUtility wdu) {
    wdu.Scroll(driver, Text);	
	}
	
	public void clickAdminPettyCash() {
		adminPettyCashTab.click();
		
	}
	

    
}
