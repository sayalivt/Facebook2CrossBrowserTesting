package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage {
	//Private global variables(declaration)
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgottenPassword;
	@FindBy(xpath="//input[@aria-label='Email address or mobile number']")
	private WebElement emailOrMobile;
	@FindBy(xpath="//button[@name='did_submit']")
	private WebElement search;
	//public constructor(initialization)
	public ForgottenPasswordPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	//public methods
	public void openforgottenPassword()
	{
		forgottenPassword.click();
	}
	public void sendEmailOrMobile()
	{
		emailOrMobile.sendKeys("sayalivarkhede96@gmail.com");
	}
	public void clickONSearchButton()
	{
		search.click();
	}
}
	
	
	
	
