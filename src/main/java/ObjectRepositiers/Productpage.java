package ObjectRepositiers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Productpage {
	WebDriver driver;
	public Productpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement productstab;


	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement addProdbtn;
	
	@FindBy(name="productName")
	private WebElement prodname;
	
	@FindBy(name="productCategory")
	private WebElement prodcategory;
	
	

	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(name="price")
	private WebElement price;
	
	@FindBy(name="vendorId")
	private WebElement vendor;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	private WebElement addprodsubbtn;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement toatsmsg;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closetoastmsg;
	
	public WebElement getProductstab() {
		return productstab;
	}

	public WebElement getAddProdbtn() {
		return addProdbtn;
	}

	public WebElement getProdname() {
		return prodname;
	}

	public WebElement getProdcategory() {
		return prodcategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendor() {
		return vendor;
	}

	public WebElement getAddprodsubbtn() {
		return addprodsubbtn;
	}
	
	public WebElement getToatsmsg() {
		return toatsmsg;
	}

	public WebElement getClosetoastmsg() {
		return closetoastmsg;
	}
	
	

}
