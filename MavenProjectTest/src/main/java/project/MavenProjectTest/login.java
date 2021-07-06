package project.MavenProjectTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login {

	@Test
	void website_login() {

	/*-------------------------LAUNCHING CHROME BROWSER----------------------------------*/
	///Users/shrey/Downloads/chrome-driver/chromedriver_win32
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrey\\Downloads\\chrome-driver\\chromedriver_win32\\chromedriver.exe");
	
	/*-------------------------URL EXECUTION-------------------------------------------*/
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://in.yahoo.com/");
	
	//driver.findElement(By.linkText("Sign in")).click();   ///to find one elements in the page and execute that 
	WebElement signin = driver.findElement(By.linkText("Sign in"));  //can intialize both ways as above and below
	signin.click();
	//Signin  -- its href name tag -- inspect on the button to get the name
	//pass only string
	
/*	
	List<WebElement> elements = driver.findElements(By.tagName("a"));
	for(WebElement e : elements)
	{
	System.out.println(e.getAttribute("href"));
	}
	*/

	driver.close();
	}
	
	
}
