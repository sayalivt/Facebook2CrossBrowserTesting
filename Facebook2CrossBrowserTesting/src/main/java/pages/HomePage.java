package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private Actions act;
	//private Variables/WebElement(variables/WebElement declaration )
	@FindBy(xpath="(//a[@role='link'])[9]")
	private WebElement profile;
	//public constructor(To initialize)
	public HomePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);		
	}
	//public Methods
	public void clickOnProfileIcon() 
	{
		act.moveToElement(profile);
		profile.click();
		act.build();
		act.perform();
	}
}	
	
	
			
			
		
				
					

