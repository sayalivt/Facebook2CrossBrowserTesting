package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoomsPage {
	//private Variables/WebElement(variables/WebElement declaration )
	@FindBy(xpath="//a[text()=' Return to messenger.com ']")
	private WebElement returnToMessenger;
	@FindBy(xpath="//a[text()=' Visit our help center ']")
	private WebElement helpCenter;
//public constructor(To initialize)
	public RoomsPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
//public Methods
	public void goBackTOMessenger()
	{
		returnToMessenger.click();	
	}
	public void contactToHelpCenter()
	{
		helpCenter.click();
	}
}			

