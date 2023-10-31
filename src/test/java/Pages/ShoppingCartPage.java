package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage{
	  private WebDriver driver;
	
	@FindBy(xpath="//span[@class='value-summary']//strong[contains(text(),'$100.00')]")
	private WebElement totbox; 
	
	@FindBy(xpath="//input[@id='termsofservice']")
	private WebElement terms ;
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement chkbtn ;
	
	public ShoppingCartPage (WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}
	public  String getTotboxText() {
      return totbox.getText();
         
    }
	public SignInPage clickCB() throws InterruptedException {			    
		      totbox.getText(); 		      
	          terms.click();
		      Thread.sleep(3000);
		      chkbtn.click();
		      Thread.sleep(3000);
		return new SignInPage(driver);
	
}
}