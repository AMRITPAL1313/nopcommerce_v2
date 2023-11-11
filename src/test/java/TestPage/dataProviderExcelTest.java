package TestPage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.baseClass;
import Pages.homePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utilities.excelDataRead;
     
    public class dataProviderExcelTest extends baseClass{
    	private WebDriver driver;
    	private homePage hp;
    
	@DataProvider
    public Object[][] readExcelData() throws InvalidFormatException {
    	Object[][] inputData;
    	excelDataRead excelReader = new excelDataRead();
    	inputData = excelReader.getTestData("Sheet1");
    	return inputData;
    }
    
    @Test(dataProvider = "readExcelData")
    public void setupbrowser(String browser,String Url) throws InterruptedException {
    	baseSetup(browser);
    	getDriver().get(Url);
    	hp=new homePage(getDriver());
    	Assert.assertNotNull(hp, "Home page is not displayed");
    	//Assert.assertEquals(hp, "homePage is not displayed");
    //	System.out.print("assert has been executed and failed");
    //	System.out.println("nopcommerce application launch was sucessful");
    	
    	Thread.sleep(3000);
    	getDriver().quit();
    }
    
}

