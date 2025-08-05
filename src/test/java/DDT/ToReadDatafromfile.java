package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToReadDatafromfile {

	public static void main(String[] args) throws IOException, InterruptedException {
		//create object of FIS
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String BROWSER= prop.getProperty("Browser");
		String URL= prop.getProperty("Url");
		String USERNAME= prop.getProperty("Username");
		String PASSWORD= prop.getProperty("Password");
		System.out.println(BROWSER);
		System.out.println(URL);
		
		WebDriver driver=null;
		if(BROWSER.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("Chrome"))
		{
			driver=new ChromeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
        driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		 Thread.sleep(2000);
        
      
		
	 //create campaign
		 driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.name("campaignName")).sendKeys("Gowsi");
		 Thread.sleep(2000);
		 WebElement target = driver.findElement(By.name("targetSize"));
		 
		 target.clear();
		 target.sendKeys("10");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		//validation
		 WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(toastmsg));
		 Thread.sleep(2000);
		 String msg = toastmsg.getText();
		 
		if(msg.contains("Gowsi"))
		{
		System.out.println("campaign created");
		}
		else {
		System.out.println("campaign not created");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		 Thread.sleep(2000);
		//logout
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act=new Actions(driver);
		act.moveToElement(icon).click().perform();
		WebElement logoutbtn
		=driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		act.moveToElement(logoutbtn).click().perform();
		driver.quit();
	}
	
}
