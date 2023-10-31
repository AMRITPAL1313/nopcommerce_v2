package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage{
	private WebDriver driver;
	
	@FindBy(xpath="//li[@id='opc-payment_method']//li[1]//div[1]//div[2]")
	private WebElement moneyorder;
	
	@FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']")
	private WebElement continuebtn3 ;

        public PaymentMethodPage(WebDriver driver) {
 		   this.driver = driver;
 		   PageFactory.initElements(driver, this);
}
    	   public  PaymentInfoPage clickPMC() throws InterruptedException{{
				moneyorder.click();
				Thread.sleep(3000);
				continuebtn3.click();
				Thread.sleep(5000);
				return new PaymentInfoPage(driver);
    	   }
    	   }
  }
  