package Campaign;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Basetest.BaceClass;
import Generic_utility.ExcelFileUtility;
import Generic_utility.PropertiesfileUtility;
import Generic_utility.WebdriverUtility;
import Generic_utility.javaUtility;
import ObjectRepositiers.Campaignpage;
import ObjectRepositiers.Homepage;
@Listeners(ListenerUtility.ListenerImplementation.class)
public class CampaignTest extends BaceClass {
	
	  @Test(groups = "smoke")
		public void tocreatecampaignwithmftest() throws IOException  {
			PropertiesfileUtility putil=new PropertiesfileUtility();
			ExcelFileUtility eutil=new ExcelFileUtility();
			
			WebdriverUtility wutil=new WebdriverUtility();
			String BROWSER= putil.togetdataFromPropertiesfile("Browser");
			String URL= putil.togetdataFromPropertiesfile("Url");
			String USERNAME= putil.togetdataFromPropertiesfile("Username");
			String PASSWORD= putil.togetdataFromPropertiesfile("Password");
		
			String CampaignName= eutil.toReadDataFromExcelfile("Campaign", 1, 2);
			String TargetSize = eutil.toReadDataFromExcelfile("Campaign", 1, 3);
		//createcampaign using repo
				
				Homepage hp=new Homepage(driver);
				hp.getCreatecamp().click();
				Campaignpage cp=new Campaignpage(driver);
				cp.getCampaignNametf().sendKeys(CampaignName);
				cp.getTargetTF().sendKeys(TargetSize);
				cp.getCreatecampsubmitBtn().click();
				
				//validation using repo
				WebElement toastmsg= cp.getToastmsg();
				wutil.waitForVisibilityOfElement(driver, toastmsg);
				String msg = toastmsg.getText();
	            Assert.assertTrue(msg.contains(CampaignName));
      			cp.getClosemsg().click();
	}
	  
	  


		@Test(groups = "regression")
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
				cp.getStatusTF().sendKeys(Status);
				cp.getCreatecampsubmitBtn().click();
				//validation using repo
				WebElement toastmsg= cp.getToastmsg();
				wutil.waitForVisibilityOfElement(driver, toastmsg);
				String msg = toastmsg.getText();
				Assert.assertTrue(msg.contains(CampaignName));
				cp.getClosemsg().click();
					// logout
		}
		
		
		@Test(groups = "smoke")
		public void tocreatecampaignwithexpecteddate() throws IOException {
			PropertiesfileUtility putil = new PropertiesfileUtility();
			ExcelFileUtility eutil = new ExcelFileUtility();
			javaUtility jutil = new javaUtility();
			WebdriverUtility wutil = new WebdriverUtility();
			String BROWSER = putil.togetdataFromPropertiesfile("Browser");
			String URL = putil.togetdataFromPropertiesfile("Url");
			String USERNAME = putil.togetdataFromPropertiesfile("Username");
			String PASSWORD = putil.togetdataFromPropertiesfile("Password");
			String CampaignName = eutil.toReadDataFromExcelfile("Campaign", 1, 2);
			String TargetSize = eutil.toReadDataFromExcelfile("Campaign", 1, 3);
			String daterequired = jutil.togetRequiredDate(30);
			
		
			// create campaign
			Homepage hp=new Homepage(driver);
			hp.getCampaign().click();
			Campaignpage cp=new Campaignpage(driver);
			cp.getCreatecamepaign().click();
			cp.getCampaignNametf().sendKeys(CampaignName);
			cp.getTargetTF().sendKeys(TargetSize);
			WebElement expClosedate=cp. getDateTF();
			wutil.passInput(driver, expClosedate, daterequired);
			cp.getCreatecampsubmitBtn().click();
			// validation
			WebElement toastmsg = cp.getToastmsg();
			wutil.waitForVisibilityOfElement(driver, toastmsg);
			String msg = toastmsg.getText();
			Assert.assertTrue(msg.contains(CampaignName));
		    cp.getClosemsg().click();
		}

}
