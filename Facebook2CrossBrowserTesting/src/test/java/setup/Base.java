//Base or Pojo
package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	public static WebDriver openEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","D:\\Selenium\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		return driver;
	}
	/*public static void openOperaBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	}*/
}
