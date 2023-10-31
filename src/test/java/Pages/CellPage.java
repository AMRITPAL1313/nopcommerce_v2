package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellPage {
	private WebDriver driver;
	
	@FindBy(xpath="//div[@class='picture']//img[@title='Show details for HTC One Mini Blue']")
	private WebElement HTCimage;
	
	public CellPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}   

	public HTCCellPage clickHTC() throws InterruptedException {
		//Actions action = new Actions(driver);
		//action.click(HTCimage)
		HTCimage.click();
		Thread.sleep(3000);
		return new HTCCellPage(driver);
	}
}
