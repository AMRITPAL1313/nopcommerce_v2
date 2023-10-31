package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethod {
	private WebDriver driver;
	
	@FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']")
	private WebElement shippingnext ;
	
	public ShippingMethod (WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}
	public PaymentMethodPage continue2() {
		shippingnext.click();
		return new PaymentMethodPage(driver);
	}
}
