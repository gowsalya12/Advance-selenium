package Product;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Basetest.BaceClass;
import Generic_utility.ExcelFileUtility;
import Generic_utility.PropertiesfileUtility;
import Generic_utility.WebdriverUtility;
import Generic_utility.javaUtility;
import ObjectRepositiers.Productpage;

public class ProductTest extends BaceClass {
	
	
	@Test
	  public void tocreateproduct() throws IOException, InterruptedException {
		
		
		PropertiesfileUtility putil = new PropertiesfileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		javaUtility jutil = new javaUtility();
		WebdriverUtility wutil = new WebdriverUtility();
		String BROWSER = putil.togetdataFromPropertiesfile("Browser");
		String URL = putil.togetdataFromPropertiesfile("Url");
		String USERNAME = putil.togetdataFromPropertiesfile("Username");
		String PASSWORD = putil.togetdataFromPropertiesfile("Password");
		// actual script
		
		String prodname = eutil.toReadDataFromExcelfile("Product", 2, 0);
		String quantity1 = eutil.toReadDataFromExcelfile("Product", 2, 1);
		String price1 = eutil.toReadDataFromExcelfile("Product", 2, 2);
		// enter details
		Productpage pp=new Productpage(driver);
		pp.getProductstab().click();
		pp.getAddProdbtn().click();
		pp.getProdname().sendKeys(prodname +jutil.togetRandomNumber());
		WebElement categorydropdown =pp.getProdcategory();
		// Dropdown 1
		wutil.select(categorydropdown, 3);
		WebElement quantity = pp.getQuantity();
		quantity.clear();
		quantity.sendKeys(quantity1);
		WebElement price = pp.getPrice();
		price.clear();
		price.sendKeys(price1);
		// DropDown 2
		WebElement vendordropdown = pp.getVendor();
		wutil.select(vendordropdown, 1);
		pp.getAddprodsubbtn().click();
		Thread.sleep(2000);
		pp.getClosetoastmsg().click();
		// logout
		

	}

}
