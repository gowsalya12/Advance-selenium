package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class threadpoolsize {
	
	@Test(invocationCount = 8, threadPoolSize = 5)
	public void loginw() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}

}
