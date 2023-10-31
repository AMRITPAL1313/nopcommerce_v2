package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage{
     private WebDriver driver;
     
 	@FindBy(xpath="//button[normalize-space()='Confirm']")
 	 WebElement confirm;
 	
         public OrderConfirmationPage(WebDriver driver) {
  		   this.driver = driver;
  		   PageFactory.initElements(driver, this);
 }
     	   public  ThankyouPage thanks() throws InterruptedException{{
     		  Thread.sleep(2000);
     		   confirm.click();
 				return new ThankyouPage(driver);
     	   }
}
}