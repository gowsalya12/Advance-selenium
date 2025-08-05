package TestNG;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demotestng {
	
	@Test
	public void a11()
	{
		Reporter.log("a11 excuted", true);
	}
	
	@Test
	public void a23()
	{
		Reporter.log("a23 excuted", true);
	}

}
