//Final Code
package package1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;
import setup.Base;
import utils.Utility;
public class VerifyRoomspage extends Base 
{
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private MessengerPage messengerPage;
	private RoomsPage roomsPage;
	private SoftAssert soft;
	int testID;
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		//System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
			//System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
			//driver=new ChromeDriver();
		}
		if(browserName.equals("FireFox"))
		{
			driver=openFirefoxBrowser();
			//System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
			//driver=new FirefoxDriver();
		}	
		System.out.println("Before Test");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObjects()
	{
		//driver.get("https://www.facebook.com/");
		loginOrSignUpPage=new LoginOrSignUpPage(driver);
		messengerPage=new MessengerPage(driver);
		roomsPage=new RoomsPage(driver);
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void openRoomsPage()
	{
		driver.get("https://www.facebook.com/");
		//1
		loginOrSignUpPage.openMessenger();
		String messengerPageUrl=driver.getCurrentUrl();
		if(messengerPageUrl.equals("https://www.messenger.com/"))
		{
			System.out.println("Messenger url is verified");
		}
		else
		{
			System.out.println("Messenger url is wrong");
		}
		//2
		messengerPage.openRooms();
		String messengerRoomPageUrl=driver.getCurrentUrl();
		if(messengerRoomPageUrl.equals("https://www.messenger.com/rooms"))
		{
			System.out.println("Messenger room page url is verified");
		}
		else
		{
			System.out.println("Messenger room page url is wrong");
		}
		//3
		soft=new SoftAssert();
		System.out.println("Before Method");
	}	
	@Test
	public void verifyGoBackToMessengerButton() throws IOException, InterruptedException
	{
		testID=1;
		roomsPage.goBackTOMessenger();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		soft.assertEquals(url, "https://www.messenger.com/");
		
		String title1=Utility.fetchDataFromExcel("Velocity", 5, 0);
		System.out.println("expected:"+title);
		System.out.println("actual"+title1);
		soft.assertEquals(title, title1);
			
	//	soft.assertEquals(title, "Messenger");
		
		soft.assertAll();
		//Utility.captureScreenshot(testID,driver);
	}
	@Test
	public void verifyGoBackToHelpCenterButton() throws IOException, InterruptedException
	{
		testID=2;
		roomsPage.contactToHelpCenter();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		soft.assertEquals(url, "https://www.messenger.com/help");
		soft.assertEquals(title, "Messenger Help Centre");
		
	//	soft.assertEquals(title, "Messenger Centre");
		soft.assertAll();
	//	driver=Utility.captureScreenshot(testID,driver);
	}
	@AfterMethod
	public void logoutFromApplication(ITestResult output) throws IOException, InterruptedException
	{
		if(ITestResult.FAILURE==output.getStatus())
		{
			System.out.println("........");
			System.out.println("Failed Test");
			Utility.captureScreenshot(testID, driver);
			System.out.println("........");
		}
		System.out.println("after method");	
	}
	@AfterClass
	public void cleanPOMObject()
	{
		loginOrSignUpPage=null;
		messengerPage=null;
		roomsPage=null;
		System.out.println("After Class");
	}
	@AfterTest
	public void closedBrowser()
	{
		driver.close();
		driver=null;
		System.gc();//Garbage Collector-Delete the unused object
		System.out.println("After Test");
	}
}
