package abhiPOMpages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS.genericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS.genericUtility.WebDriverUtility;

public class PettyCashPage {

	@FindBy(xpath = "//span[text()='Petty Cash']")
	private WebElement pettyCash;
	
	@FindBy(xpath = "//a[@onclick='showModal()']")
	private WebElement button;

	@FindBy(id = "textDesc_1")
	private WebElement itemName;
	@FindBy(id = "textAmount_1")
	private WebElement itemAmount;
	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;


	public PettyCashPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Business Library
	/**
	 * This method is used to get data from excel by giving key as input
	 * 
	 * @param webdriver
	 * @param excelUtility
	 * @return
	 */

	public Map<String, String> addPettyCash(WebDriverUtility webdriver, ExcelUtility excelUtility) {

		Map<String, String> map = excelUtility.getDataFromExcelFile("Pettycash", "Pettycash ");
		pettyCash.click();
		button.click();
		itemName.sendKeys(map.get("entername"));
		itemAmount.sendKeys(map.get("admissionfee"));
		submitBtn.click();
		return map;

	}
	
}
