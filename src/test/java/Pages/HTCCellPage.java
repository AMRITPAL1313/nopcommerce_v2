package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HTCCellPage {
	private WebDriver driver;
	@FindBy(xpath="//button[@id='add-to-cart-button-19']")
	@CacheLookup
	private WebElement addtocartbtn;
	
	@FindBy(xpath="//span[@class='cart-label']")
	@CacheLookup
	private WebElement shcart;
	
	public HTCCellPage (WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}
	public ShoppingCartPage clickAC() {
		new Actions(driver)
		.click(addtocartbtn)
		.pause(5000)
		.click(shcart)
		.pause(3000)
		.perform();
		return new ShoppingCartPage(driver);
	}
	
}   


