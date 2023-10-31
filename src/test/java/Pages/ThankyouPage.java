package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	
	public class ThankyouPage {
	     private WebDriver driver;
	     
	 	@FindBy(xpath="//button[normalize-space()='Continue']")
	 	private WebElement continuethank ;
	 	
	 
	    public ThankyouPage(WebDriver driver) {
			   this.driver = driver;
			   PageFactory.initElements(driver, this);
	    }
	    
		public CompletePage epage() throws InterruptedException {
			Thread.sleep(5000);
			continuethank.click();
			return new CompletePage();
		}
	}

