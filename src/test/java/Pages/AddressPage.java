package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")
	 private WebElement FirstNameinput ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']")
	private WebElement LastNameinput;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Email']")
	private WebElement Emailinput;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	 private WebElement CountryDropdown;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
	private WebElement ProvinceDropdown ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	private WebElement Cityinput ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	private WebElement Address1input ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	 private WebElement Zipcodeinput ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	 private WebElement PhoneNumberinput ;
	
	@FindBy(xpath="//button[@onclick='Billing.save()']")
	 private WebElement Continuebtn1 ;
	
	public AddressPage (WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	public ShippingMethod InputData(){
		FirstNameinput.sendKeys("AMRITPAL");
		LastNameinput.sendKeys("KAUR");
		Emailinput.sendKeys("amritkaursidhu2020@gmail.com");		
		Select country = new Select(CountryDropdown);
        country.selectByVisibleText("Canada");
        Select provinceSelect = new Select(ProvinceDropdown);
        provinceSelect.selectByVisibleText("Ontario");
        Cityinput.sendKeys("oshawa");
		Address1input.sendKeys("114 ADELAIDE AVE E");
		Zipcodeinput.sendKeys("L1G1Z1");
		PhoneNumberinput.sendKeys("5815798054");
		Continuebtn1.click();
		return new ShippingMethod(driver);
	 
	 }  
	
}