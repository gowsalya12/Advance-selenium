package Implementationofutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Basetest.BaceClass;
import Generic_utility.ExcelFileUtility;
import Generic_utility.PropertiesfileUtility;
import Generic_utility.WebdriverUtility;
import ObjectRepositiers.Campaignpage;
import ObjectRepositiers.Homepage;
import ObjectRepositiers.Loginpage;

public class Createacampaignwithstatus extends BaceClass
{

	@Test
	public void tocreatecampaignwithstatus() throws IOException{
		PropertiesfileUtility putil=new PropertiesfileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		
		WebdriverUtility wutil=new WebdriverUtility();
		String BROWSER= putil.togetdataFromPropertiesfile("Browser");
		String URL= putil.togetdataFromPropertiesfile("Url");
		String USERNAME= putil.togetdataFromPropertiesfile("Username");
		String PASSWORD= putil.togetdataFromPropertiesfile("Password");
	    String CampaignName= eutil.toReadDataFromExcelfile("Campaign", 1, 2);
		String TargetSize = eutil.toReadDataFromExcelfile("Campaign", 1, 3);
		String Status= eutil.toReadDataFromExcelfile("Campaign", 1, 4);
//createcampaign using repo
			Homepage hp=new Homepage(driver);
			hp.getCreatecamp().click();
			Campaignpage cp=new Campaignpage(driver);
			cp.getCampaignNametf().sendKeys(CampaignName);
			cp.getTargetTF().sendKeys(TargetSize);
			cp.getCreatecampsubmitBtn().click();
			cp.getStatusTF().sendKeys(Status);		
			//validation using repo
			WebElement toastmsg= cp.getToastmsg();
			wutil.waitForVisibilityOfElement(driver, toastmsg);
			String msg = toastmsg.getText();
			
			if (msg.contains(CampaignName)) {
				System.out.println("campaign created");
				}
				else {
				System.out.println("campaign not created");
				}
				cp.getClosemsg().click();
				// logout
	}

	}


