package TestPage;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.baseClass;
import Pages.homePage;
import Utilities.mySqlConnect;

public class dataProviderMySqlTest extends baseClass{
	
	private WebDriver driver;
	private homePage hp;
		
	@DataProvider
	public Object[][] mySqlReadData() throws ClassNotFoundException, SQLException {
		
		Object[][] data = mySqlConnect.getMySqlData();
		return data;
	}
	
	@Test(dataProvider = "mySqlReadData")
	public void SetUpTest(String Url, String browser,String dummy) throws InterruptedException {
		baseSetup(browser, Url);
		driver = getDriver();
		getDriver().get(Url);
		hp = new homePage(getDriver());
		Assert.assertNotNull(hp,"ERROR: nopCommerce homepage is not launched!");
		tearDown();
	}

}
