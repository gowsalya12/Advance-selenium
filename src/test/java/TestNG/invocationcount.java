package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class invocationcount {
	
	@Test(invocationCount = 4)
	public void login() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}

}
