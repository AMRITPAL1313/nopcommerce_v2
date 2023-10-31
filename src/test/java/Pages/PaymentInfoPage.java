package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

   public class  PaymentInfoPage{
   private WebDriver driver;
	
   @FindBy(xpath="//button[@class='button-1 payment-info-next-step-button']")
	private WebElement continuebtn4;
   
	public PaymentInfoPage (WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
		   
}
    public OrderConfirmationPage clickPN() throws InterruptedException{
       continuebtn4.click();
       Thread.sleep(5000);
	return new OrderConfirmationPage(driver);
    	   
    }
 }