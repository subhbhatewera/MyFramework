package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.Base;
import util.ReadData;

public class PlaceOrderSkirtsTest extends Base{
	
	WebDriver driver ;
	LandingPage landing;
	LoginPage login ;
	ProductsPage products ;
	ProductDetailsPage productDetails ;
	YourCartPage yourCart;
	InformationPage info;
	ShippingPage shipping;
	PaymentPage payment;	
	OrderConfirmationPage orderConfirmation;
	MyAccountPage myAccount;
	
	@BeforeClass
	public void setUp() {
		driver = invokeBrowser();
		driver.get("https://gili-products.myshopify.com");
		landing = new LandingPage(driver);
	}
	
	@Test(dataProviderClass = ReadData.class, dataProvider = "Skirts Data")
	public void placeOrderBySelectingSkirts(String username, String password, String productName, String shippigRate,
			String cardNumber, String nameOnCard, String expiryDate, String securityCode) {
		
		driver.manage().deleteAllCookies();
		
		login = landing.clickOnLoginLink();
		
		myAccount = login.doLogin(username, password);		
		
		boolean flag = myAccount.validateCustomerName(nameOnCard);
		
		Assert.assertTrue(flag);
		
		products = landing.clickOnSkirtsLink();
		
		productDetails = products.selectProduct(productName);
		
		yourCart = productDetails.clickOnAddToCartButton();
		
		info = yourCart.clickOnCheckOutButton();
		
		shipping = info.clickOnContinueToShippingButton();
		
		shipping.selectShipping(shippigRate);
		
		payment = shipping.clickOnContinueToPaymentButton();
		
		payment.enterCardNumber(cardNumber);
		
		payment.enterName(nameOnCard);
		
		payment.enterExpirationDate(expiryDate);
		
		payment.enterSecutiryCode(securityCode);
		
		orderConfirmation = payment.clickOnPayNowBtn();
		
		Assert.assertEquals(orderConfirmation.getOrderConfirmation(), "Thank you");
		
		orderConfirmation.clickOnContinueShoppingButton();
		
		landing.clickOnAccountLink();
		
		myAccount.clickOnLogout();			
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();	
	}
	
	
}
