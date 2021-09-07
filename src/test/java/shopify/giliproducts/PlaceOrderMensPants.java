package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;
import util.ReadData;

public class PlaceOrderMensPants extends Base{
	
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
	
	@BeforeTest
	public void setUp() {
		driver = invokeBrowser();
		driver.get("https://gili-products.myshopify.com");
		landing = new LandingPage(driver);
	}
	
	@Test(dataProviderClass = ReadData.class, dataProvider = "Simple Order Data")
	public void placeOrder(String username, String password, String productName, String shippigRate,
			String cardNumber, String nameOnCard, String expiryDate, String securityCode) {
		
		login = landing.clickOnLoginLink();
		
		myAccount = login.doLogin(username, password);		
		
		boolean flag = myAccount.validateCustomerName(nameOnCard);
		
		Assert.assertTrue(flag);
		
		products = landing.clickOnMensPantsLink();
		
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
	
	@AfterTest
	public void tearDown() {
		driver.quit();	
	}
	
	
}
