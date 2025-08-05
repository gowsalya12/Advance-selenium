package ObjectRepositiers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//@FindAll({@FindBy(id="username"),@FindBy(name="username")})  [it is a autohealing process in pom]
	@FindBy(id="username")
	private WebElement UN;
	@FindBy(id="inputPassword")
	private WebElement PW;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginbut;
	public WebElement getUN() {
		return UN;
	}
	public WebElement getPW() {
		return PW;
	}
	public WebElement getLoginbut() {
		return loginbut;
	}
	
	
	

}
