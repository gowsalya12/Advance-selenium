package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class dependsOnMethod {
	
	@Test
	public void addcart()
	{
		Reporter.log("added", true);
	}
	
	@Test(dependsOnMethods = "addcart")
	public void editcart()
	{
		Reporter.log("edited", true);
	}
	
	@Test(dependsOnMethods = {"edited","addcart"})
	public void deletecart()
	{
		Reporter.log("deleted", true);
	}
}
