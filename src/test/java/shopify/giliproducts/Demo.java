package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.Base;
import util.ReadData;

public class Demo extends Base{
	
	WebDriver driver ;
	LandingPage landing;
	LoginPage login ;
	MyAccountPage myacc;
	
	@BeforeClass
	public void setUp() {
		driver = invokeBrowser();
		driver.get("https://gili-products.myshopify.com");
		landing = new LandingPage(driver);
	}
	
	@Test(dataProviderClass = ReadData.class, dataProvider = "credentials")
	public void login(String username, String password, String name) {
		
		login = landing.clickOnLoginLink();
		
		myacc =  login.doLogin(username, password);	
		
		boolean flag = myacc.validateCustomerName(name);
		
		Assert.assertTrue(flag);
		
		myacc.clickOnLogout();
	}

}
