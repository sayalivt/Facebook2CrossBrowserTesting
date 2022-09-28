package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	//private WebDriver driver;
	//private  WebDriverWait wait;
	//private Variables/WebElement(variables/WebElement declaration )
		@FindBy(xpath="//span[text()='Add to Story']")
		private WebElement addToStory ;
		//span[text()='Edit profile']
		@FindBy(xpath="//span[text()='Edit profile']")
		private WebElement editProfile;
	//public constructor(To initialize)
		public ProfilePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			//this.driver=driver;
		}
	//public Methods
		public void clickOnAddToStoryButton() throws InterruptedException 
		{
			Thread.sleep(3000);
			//wait=new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.visibilityOf(addToStory));
			addToStory.click();	
		}
		public void clickOnEditProfileButton() throws InterruptedException 
		{
			Thread.sleep(3000);
			//wait=new WebDriverWait(driver,40);
			//wait.until(ExpectedConditions.visibilityOf(editProfile));
			editProfile.click();
		}
}
