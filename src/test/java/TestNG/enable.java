package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class enable {
	
	@Test
	public void a23()
	{
		Reporter.log("a23", true);
	}

	@Test
	public void r45()
	{
		Reporter.log("r45", true);
}
	
	@Test(enabled = false)
	public void e34()
	{
		Reporter.log("e34", true);
	}
}
