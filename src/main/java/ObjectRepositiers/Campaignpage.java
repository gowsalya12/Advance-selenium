package ObjectRepositiers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignpage {
     WebDriver driver;
	public Campaignpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[text()='Create Campaign']")
	private WebElement createcamepaign;
	
	@FindBy(name="campaignName")
	private WebElement campaignNametf;
	
	@FindBy(name="campaignStatus")
	private WebElement statusTF;
	
	@FindBy(name="targetSize")
	private WebElement targetTF;
	
	@FindBy(name="expectedCloseDate")
	private WebElement dateTF;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createcampsubmitBtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastmsg;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closemsg;
	
	public WebElement getCreatecamepaign() {
		return createcamepaign;
	}
	
	public WebElement getCampaignNametf() {
		return campaignNametf;
	}

	public WebElement getStatusTF() {
		return statusTF;
	}

	public WebElement getTargetTF() {
		return targetTF;
	}

	public WebElement getDateTF() {
		return dateTF;
	}

	public WebElement getCreatecampsubmitBtn() {
		return createcampsubmitBtn;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}

	public WebElement getClosemsg() {
		return closemsg;
	}

	
}

