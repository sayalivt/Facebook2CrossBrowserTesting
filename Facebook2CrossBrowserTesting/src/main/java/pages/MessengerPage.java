package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {
		private WebDriver driver;
	//private Variables/WebElement(variables/WebElement declaration )
			@FindBy(xpath="//a[text()='Rooms']")
			private WebElement room;
			@FindBy(xpath="//a[text()='Features']")
			private WebElement features;
			@FindBy(xpath="//a[text()='Privacy and safety']")
			private WebElement privacyAndSafety;
			
		//public constructor(To initialize)
			public MessengerPage(WebDriver driver)
			{
			PageFactory.initElements(driver, this);
			this.driver=driver;
			}
		//public Methods
			public void openRooms()
			{
				room.click();
			}
			public void openFeatures()
			{
				features.click();
			}
			public void openprivacyAndSafety()
			{
				privacyAndSafety.click();
			}
	}			

