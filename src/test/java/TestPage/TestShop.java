package TestPage;

	import java.io.IOException;
	import java.util.Properties;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import java.io.FileReader;
	import com.aventstack.extentreports.ExtentTest;
	import Pages.AddressPage;
	import Pages.CellPage;
	import Pages.CompletePage;
	import Pages.HTCCellPage;
	import Pages.OrderConfirmationPage;
	import Pages.PaymentInfoPage;
	import Pages.PaymentMethodPage;
	import Pages.ShippingMethod;
	import Pages.ShoppingCartPage;
	import Pages.SignInPage;
	import Pages.ThankyouPage;
	import Pages.baseClass;
	import Pages.homePage;
	import org.testng.annotations.Test;
	public class TestShop extends baseClass{
		private homePage hp;
		private CellPage cp;
		private SignInPage sip;
		private HTCCellPage hcp;
		private ShoppingCartPage scp;
		private AddressPage ap;
		private ShippingMethod sm;
		private PaymentMethodPage pmp;
		private PaymentInfoPage pip;
		private OrderConfirmationPage ocp;
		private ThankyouPage typ;
		private CompletePage cpp;
		public static Logger Log;
		public ExtentTest test;
	    private Properties props;
	    //private static String base_url = "http://demo.nopcommerce.com/";
	   // private static String browser = "firefox";
	   //private CustomSoftAssert softAssert = new CustomSoftAssert();

		@BeforeTest
		public void baseSetup() throws InterruptedException, IOException  { 
		  PropertyConfigurator.configure("src/test/resources/logs/log4j.properties");
		  Log = Logger.getLogger(TestShop.class.getName());
		  Log.info("setting up the browser for the test");
		  
		   //read the properties file
			 try {
				  props= propFileReader();
			 }catch(IOException e) {
				  e.printStackTrace();
			  }
	  //  baseSetup(props.getProperty("browser"),props.getProperty("base_url")); 
		       
		 baseSetup("firefox", "https://demo.nopcommerce.com/");
		  hp = new homePage(getDriver());
		  cp=new CellPage(getDriver());
		  Assert.assertNotNull(hp, "home page is not displayed");
		  System.out.println("assert has been executed and failed");
		  System.out.println("nopcommerce application launch was successfully!");
	
		 
		  if(getDriver()!=null) {
			  getDriver().get(props.getProperty("base_url"));
		  }
 }  
		//method for propFileReader inside the test page
		  public static Properties propFileReader() throws IOException {
		        Properties props = new Properties();
		        String propfile = System.getProperty("user.dir") + "/src/test/resources/logs/config.properties";
		        FileReader reader = new FileReader(propfile);
		        props.load(reader);
				return props;
		  }
		
		@Test(priority=1)
		public void electronicsTab() throws InterruptedException {
		cp=hp.hoverelectronicsTab();
    	System.out.println(getDriver().getTitle());
		System.out.println(getDriver().getCurrentUrl());
		if (getDriver().getTitle().equalsIgnoreCase("nopCommerce demo store. Cell phones")) {
		System.out.println("nopCommerce Cellphone page is launched successfully!");
	     }else {
		System.out.println("nopCommerce page Title is not Cellphone.Investigate further!");
		Assert.assertEquals(getDriver().getTitle(), "nopCommerce demo store. Cell phones", "ERROR !! nopCommerce Cellphone page is NOT launched!"); 
	   	Assert.assertNotNull(cp, "ERROR !! CellPhone page is not displayed.");
		 Log.info("nopCommerce Cellphone page is launched successfully!");
	  }
}
		@Test(priority=2)	
		public void HTCimage() throws InterruptedException {
			hcp= cp.clickHTC();
			Assert.assertNotNull(hcp,"HTC cell page link click failure!");
			System.out.println("HTC cell page is loaded");
		    Log.info("HTCCell page image click successfully");
		} 

		@Test(priority=3)	
		public void clickAC() throws InterruptedException {	
			Thread.sleep(5000);
			getDriver().navigate().refresh();
			scp = hcp.clickAC();
			Assert.assertNotNull(scp,"ERROR !!shopping cart link click failure!");
			System.out.println("shopping cart page is loaded");
			 Log.info("Shopping cart page is loaded successfully.");
		}  

		@Test(priority=4)
		public void termschkbtn() throws InterruptedException {
			String totalboxText = scp.getTotboxText();
			System.out.println("Shopping Cart Total: " + totalboxText);
			sip = scp.clickCB();
			Assert.assertNotNull(sip,"ERROR !! SignInPage  link click failure!");
			System.out.println("SignInpage is loaded");
		 Log.info("SignInpage is loaded successfully.");
	}
		
		@Test(priority=5)
		public void guestbtn() {
			ap = sip.clickGUEST();
			Assert.assertNotNull(ap," address page link click failure!");
			System.out.println("AddressPage is loaded");
		    Log.info("click on checkoutasguest button");
		}
		@Test(priority=6)
		public void continuebtn1() throws InterruptedException {
			Thread.sleep(3000);
			sm=ap.InputData();
			Assert.assertNotNull(sm,"shippingMethod link click failure!");
		    System.out.println("shippingMethod is loaded");
		    Log.info("Fill the billing info and click continue");
		}
		@Test(priority=7)
		public void shippingnext() {
			pmp=sm.continue2();
			Assert.assertNotNull(pmp,"PaymentMethod Page link click failure!");
		    System.out.println("PaymentMethod Page is loaded");
		    Log.info("click on continue button");
		}
		@Test(priority=8)
		public void continuebtn3() throws InterruptedException {
		    pip=pmp.clickPMC();
		   Assert.assertNotNull(pip,"PaymentInfoPage link click failure!");
		   System.out.println("PaymentInfoPage is loaded");
		    Log.info("click on continue button");
		}
		@Test(priority=9)
		public void continuebtn4() throws InterruptedException {
		    ocp=pip.clickPN();
		    Assert.assertNotNull(ocp,"OrderConfirmationPage link click failure!");
		    System.out.println("OrderConfirmationPage is loaded");
		    Log.info("click on continue button");
		}
		@Test(priority=10)
		public void confirm() throws InterruptedException {
		    typ=ocp.thanks();
		    Assert.assertNotNull(typ,"ThankyouPage link click failure!");
		    System.out.println("ThankyouPage is loaded");
		    Log.info("click on confirm button");
		}
		@Test(priority=11)
		public void continuethank() throws InterruptedException {
			cpp=typ.epage();
		    Assert.assertNotNull(cpp,"CompletePage link click failure!");
			 System.out.println("CompletePage is loaded");
		     Log.info("click on continue button and homepage is displayed");
		}
		@AfterTest
	    public void afterTest() {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        getDriver().quit();
	       
	    }  
	

}
