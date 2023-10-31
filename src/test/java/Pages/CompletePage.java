package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage extends baseClass {
	  
		@FindBy(xpath="//img[@alt='nopCommerce demo store']")
		private WebElement complete;
		
		public CompletePage (){
			PageFactory.initElements(getDriver(), this);
		}
		
}
