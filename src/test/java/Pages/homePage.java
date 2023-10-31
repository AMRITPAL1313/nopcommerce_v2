package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class homePage {
	private WebDriver driver;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
	private WebElement electronicstab;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
	private WebElement cellphonestab;
	
	public homePage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
	}

	public CellPage hoverelectronicsTab() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(electronicstab).pause(5000)
        .moveToElement(cellphonestab).pause(5000)
        .click().perform();
        Thread.sleep(5000);
        return new CellPage(driver);
	}
	
}