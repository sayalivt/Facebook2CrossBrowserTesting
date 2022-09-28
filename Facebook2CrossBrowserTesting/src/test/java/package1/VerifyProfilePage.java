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
import pages.HomePage;
import pages.LoginOrSignUpPage;
import pages.ProfilePage;
import setup.Base;
import utils.Utility;
public class VerifyProfilePage extends Base
{
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private HomePage homePage;
	private ProfilePage profilepage;
	private SoftAssert soft;
	int testID;
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		System.out.println(browserName);
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
	public void createPOMObjects() throws IOException
	{
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage=new LoginOrSignUpPage(driver);
		
		String user=Utility.fetchDataFromExcel("Velocity", 0, 1);
		System.out.println(user);
		loginOrSignUpPage.SendUserName(user);
		
		String pass=Utility.fetchDataFromExcel("Velocity", 1, 0);
		System.out.println(pass);
		loginOrSignUpPage.SendPassword(pass);
		
		loginOrSignUpPage.clickOnLoginButton();
		
		
		homePage=new HomePage(driver);
		profilepage=new ProfilePage(driver);
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void openProfilePage() throws InterruptedException, IOException
	{
		driver.get("https://www.facebook.com/");
//		loginOrSignUpPage.SendUserName();
//		loginOrSignUpPage.SendPassword();
//		loginOrSignUpPage.clickOnLoginButton();
		//1
		homePage.clickOnProfileIcon();
		String profilePageUrl=driver.getCurrentUrl();
		if(profilePageUrl.equals("https://www.facebook.com/profile.php?id=100082579959029"))
		{
			System.out.println("profilePage Url is verified");
		}
		else
		{
			System.out.println("profilePage Url is wrong");
		}
		//3
		soft=new SoftAssert();
		System.out.println("Before Method");	
	}
	@Test
	public void verifyAddToStoryButton() throws InterruptedException, IOException 
	{
		testID=3;
		//Thread.sleep(3000);
		profilepage.clickOnAddToStoryButton();
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
	/*	if(url.equals("https://www.facebook.com/stories/create")||(title.equals("Create stories | Facebook")))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		System.out.println("Test1");*/
		
		soft.assertEquals(url, "https://www.facebook.com/stories/create");
		soft.assertEquals(title, "Create stories | Facebook");
		
		soft.assertAll();	
	}		
@Test
	public void verifyEditProfileButton() throws InterruptedException, IOException 
	{
		testID=4;
		Thread.sleep(3000);
		profilepage.clickOnEditProfileButton();
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		Thread.sleep(3000);
		System.out.println(url);
		String title=driver.getTitle();
		Thread.sleep(3000);
		System.out.println(title);	
	/*	if(url.equals("https://www.facebook.com/profile.php?id=100082579959029")||(title.equals("Sayali Sanjay Varkhede|Facebook")))
		{
			Thread.sleep(3000);
			System.out.println(url);
			Thread.sleep(3000);
			System.out.println(title);
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		System.out.println("Test2");*/
		soft.assertEquals(url, "https://www.facebook.com/profile.php?id=100082579959029");
		soft.assertEquals(title, "Sayali Sanjay Varkhede | Facebook");
		
		soft.assertAll();		
	}
	@AfterMethod
	public void logoutFromApplication(ITestResult output) throws IOException, InterruptedException
	{
		//if(ITestResult.FAILURE==output.getStatus())
		if(ITestResult.SUCCESS==output.getStatus())
		{
			System.out.println("........");
			//System.out.println("Failed Test");
			System.out.println("pass Test");
			Utility.captureScreenshot(testID, driver);
			System.out.println("........");
		}
		System.out.println("after method");
	}
	@AfterClass
	public void cleanPOMObject()
	{
		loginOrSignUpPage=null;
		homePage=null;
		profilepage=null;
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



