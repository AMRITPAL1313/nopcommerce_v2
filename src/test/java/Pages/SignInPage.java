package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage{
	private WebDriver driver;
	@FindBy(xpath="	//button[normalize-space()='Checkout as Guest']")
	@CacheLookup
	private WebElement guest ;
	
	public SignInPage (WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}
	public  AddressPage clickGUEST() {
		new Actions(driver)
		.click(guest)
		.pause(3000)
		.perform();
		return new AddressPage(driver);
	
	}
}
