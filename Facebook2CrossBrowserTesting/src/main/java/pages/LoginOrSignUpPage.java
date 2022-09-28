//This is my first POM Class
package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	private WebDriver driver;
//private Variables/WebElement(variables/WebElement declaration )
	@FindBy(xpath="//input[@id='email']")
	private WebElement userName;
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginButton;
	@FindBy(xpath="//a[text()='Create New Account']")
	private WebElement createNewAccount;
	@FindBy(xpath="//a[text()='Messenger']")
	private WebElement messengerLink;
//public constructor(To initialize)
	public LoginOrSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
//public Methods
	public void SendUserName(String user)
	{
		userName.sendKeys(user);
	}
	public void SendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public void clickOnCreateNewAccount()
	{
		createNewAccount.click();
	}
	public void openMessenger()
	{
		messengerLink.click();
	}
	
	//or complete Functionality
	//public void LoginInToApplication() 
	//{
	//	userName.sendKeys("sayali22varkhede@gmail.com");
	//	password.sendKeys("sayali22@g");
	//	loginButton.click();
	//}
}
