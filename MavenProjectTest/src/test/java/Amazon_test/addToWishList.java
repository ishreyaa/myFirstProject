package Amazon_test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addToWishList {
	
	public static WebDriver driver;
	public static String ParentWindow = null;
	
	@BeforeTest
	void launchWebsite() throws InterruptedException
	{
		
	driverInti d = new driverInti();
	driver = d.getDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	Thread.sleep(1000);
	ParentWindow = driver.getWindowHandle();
	}
	

	
	public static void login()
	{
		driver.findElement(By.name("email")).sendKeys("9743042888");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		driver.findElement(By.name("password")).sendKeys("Shreya006@");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		Set<String> newWindow = driver.getWindowHandles();
		for(String a : newWindow)
		{
			if(a!=ParentWindow)
			{
				driver.switchTo().window(a);
			}
		}
	}
	


	@Test(priority = 1)
	void navigatingToProducts() throws InterruptedException, AWTException
	{
WebElement menu = driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[1]/a[1]/span[1]"));
		
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(menu).click().build().perform();
		Thread.sleep(1000);
		
		Robot r = new Robot();
		for (int i = 0 ; i<13; i++)
		{	
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.setAutoDelay(200);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.setAutoDelay(200);
		
		for (int i = 0 ; i<3; i++)
		{	
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.setAutoDelay(200);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.setAutoDelay(200);
	}
	
	@Test(priority = 2)
	void applyFilter()
	{
		WebElement catogory = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Dresses & Jumpsuits')]")));
		catogory.click();
		
		WebElement cod = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.linkText("Eligible for Pay On Delivery")));
		cod.click();
		
		WebElement mediumsize = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='p_n_size_five_browse-vebin/1975367031']")));
		mediumsize.click();
		
		WebElement colour = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='p_n_size_two_browse-vebin/1975328031']")));
		colour.click();
		
		WebElement product = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div[11]/div[1]/span[1]/div[1]/div[1]/div[2]")));
		product.click();
		
		Set<String> newWindow = driver.getWindowHandles();
		for(String windowhan : newWindow)
		{
			if(windowhan !=ParentWindow)
			{
				driver.switchTo().window(windowhan);
			}
		}
	}
	
	@Test(priority = 3)
	void addToWishL() throws InterruptedException
	{
		WebElement wishList = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.name("submit.add-to-registry.wishlist.unrecognized")));
		wishList.click();
		
		login();
		
		WebElement add = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-wishlist-button-submit']")));
		add.click();
		
		WebElement close = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//header/button[1]")));
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.doubleClick(close).perform();
	}
	

	WebDriver getWebdriver()
	{
		return driver;
		
	}
}
