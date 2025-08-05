package ObjectRepositiers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver, this);
	}
	@FindBy(linkText="Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText="Products")
	private WebElement products;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createcamp;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement userIcon;
	
	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logoutbtn;

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getCreatecamp() {
		return createcamp;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	
	
	

}
