package Amazon_test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class selectandcheckout {
	
	public static WebDriver driver;
	public static String ParentWindow = null;
	
	@AfterSuite
	void closeWindow()
	{
		driver.quit();
	}
	
	@BeforeClass
	void windowhandling() throws InterruptedException
	{
		
	addToWishList d = new addToWishList();
	driver = d.getWebdriver();
	ParentWindow = driver.getWindowHandle();
	}
	
	
	@Test(priority = 1)
	void searchProductUsingSearchBox() throws InterruptedException
	{
		WebElement searchItem = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
		searchItem.sendKeys("Chumbak watches for women");
		Thread.sleep(1500);
		WebElement search = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='nav-search-submit-button']")));
		search.click();
		
		
		
		WebElement watches = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div[2]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/span[1]/a[1]")));
		watches.click();
		Thread.sleep(1500);
		
		Set<String> newchildWindow = driver.getWindowHandles();
		for(String a : newchildWindow)
		{
			if(a!=ParentWindow)
			{
				driver.switchTo().window(a);
				
			}
		}
	}
	
	@Test(priority = 2)
	void addToCart() throws InterruptedException
	{
		WebElement addToCart = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']")));
		addToCart.click();
		Thread.sleep(1500);
		WebElement proceedtobuy = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='hlb-ptc-btn-native']")));
		proceedtobuy.click();
	}
	
	@Test(priority = 3)
	void addAddress() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys("shreya");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("9743042888");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("560010");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("45");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']")).sendKeys("Mahaganapathi nagar, West of chord road,Rajajinagar ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-landmark']")).sendKeys("Next to bharat lights");
		Thread.sleep(1000);
		
		WebElement state = driver.findElement(By.xpath("//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']"));
		Select selectstate = new Select(state);
		selectstate.selectByValue("KARNATAKA");
		Thread.sleep(1000);
		
		WebElement submit = driver.findElement(By.xpath("//span[@id='address-ui-widgets-form-submit-button']"));
		submit.click();
	}
	
	@Test(priority = 4)
	void checkOut() throws InterruptedException, AWTException
	{
	Thread.sleep(5000);
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	r.setAutoDelay(200);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	Thread.sleep(7000);
	
	/*
	WebElement payment =  driver.findElement(By.xpath("//input[@id='pp-s1pSMP-118']"));
	payment.click();
	
	WebElement checkout =  new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='checkoutDisplayPage']/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/input[1]")));
	checkout.click();
		WebElement checkoutdisplay =  driver.findElement(By.xpath("//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/input[1]"));
	checkoutdisplay.click();*/
	}

}
