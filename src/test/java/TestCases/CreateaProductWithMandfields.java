package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateaProductWithMandfields {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 //login to NINZA CRM
		 driver.get("http://49.249.28.218:8098/");
		 driver.findElement(By.id("username")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		 Thread.sleep(2000);
		 
		 //Create a Product
		 driver.findElement(By.linkText("Products")).click();
		 driver.findElement(By.xpath("//span[contains(text(),'Add Product')]")).click();
		 driver.findElement(By.name("productName")).sendKeys("Iphone13");
		 
				
				WebElement categorydropdown=driver.findElement(By.name("productCategory"));
				//Dropdown 1
				Select drop1=new Select(categorydropdown);
				drop1.selectByValue("Electricals");
				WebElement quantity=driver.findElement(By.name("quantity"));
				quantity.clear();
				quantity.sendKeys("7");
				
				WebElement price=driver.findElement(By.name("price"));
				price.clear();
				price.sendKeys("89000");
				//DropDown 2
				WebElement vendordropdown=driver.findElement(By.name("vendorId"));
				Select drop2=new Select(vendordropdown);
				drop2.selectByValue("VID_007");
				driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
				 
				WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.visibilityOf(toastmsg));
				 Thread.sleep(2000);
				 String msg = toastmsg.getText();
				 
				if(msg.contains("Iphone13"))
				{
				System.out.println("product created");
				}
				else {
				System.out.println("product not created");
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
