package AmazonEcommerse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverInti {
	
	private WebDriver driver ;
	
	public WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrey\\Downloads\\chrome-driver\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver();
		return driver;
	}
	
	public void setDriver(WebDriver d)
	{
		this.driver = d;
		
	}
	
}
