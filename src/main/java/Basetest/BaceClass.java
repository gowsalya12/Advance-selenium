package Basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Generic_utility.PropertiesfileUtility;
import Generic_utility.WebdriverUtility;
import ObjectRepositiers.Homepage;
import ObjectRepositiers.Loginpage;

public class BaceClass {
	
	public WebDriver driver=null;
	public PropertiesfileUtility putil=new PropertiesfileUtility();
	public WebdriverUtility wutil=new WebdriverUtility();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforesuite()
	{
		System.out.println("Db connectivity open");
	}
	
	@BeforeClass(groups = {"smoke","regression"})
	public void beforeclass() throws IOException
	{
		String BROWSER= putil.togetdataFromPropertiesfile("Browser");
		if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
			} else if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
			} else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
			}
	}
	
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforemethod() throws IOException
	{
		String URL= putil.togetdataFromPropertiesfile("Url");
		String USERNAME= putil.togetdataFromPropertiesfile("Username");
		String PASSWORD= putil.togetdataFromPropertiesfile("Password");
	
		System.out.println("login");
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
		Loginpage lp=new Loginpage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginbut().click();
	}
	
	
	@AfterMethod(groups = {"smoke","regression"})
	public void aftermethod()
	{
		Homepage hp=new Homepage(driver);
		
		System.out.println("logout");
		WebElement	icon= hp.getUserIcon();
		wutil.mouseHoverOnWebElement(driver, icon);
		WebElement logout= hp.getLogoutbtn();
		wutil.clickOnWebElement(driver, logout);
	}
	
	
	@AfterClass(groups = {"smoke","regression"})
	public void afterclass()
	{
		System.out.println("closing the browser");
		driver.quit();	
	}
	
	
	@AfterSuite(groups = {"smoke","regression"})
	public void aftersuite()
	{
		System.out.println("Db close");
	}

}
