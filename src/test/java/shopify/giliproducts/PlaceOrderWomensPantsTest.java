package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.Base;
import util.ReadData;

public class PlaceOrderWomensPantsTest extends Base{
	
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
		
		landing = new LandingPage(driver);	
		
		openLandingPage();	
		
	}
	
	@Test(dataProviderClass = ReadData.class, dataProvider = "Coupon Code Order Data")
	public void placeOrderBySelectingWomensPants(String username, String password, String productName, String couponCode, 
			String shippigRate,	String cardNumber, String nameOnCard, String expiryDate, String securityCode) {
		
		deleteCookies();
		
		login = landing.clickOnLoginLink();
		
		myAccount = login.doLogin(username, password);		
		
		boolean flag = myAccount.validateCustomerName(nameOnCard);
		
		Assert.assertTrue(flag);
		
		products = landing.clickOnWomensPantsLink();
		
		productDetails = products.selectProduct(productName);
		
		yourCart = productDetails.clickOnAddToCartButton();
		
		info = yourCart.clickOnCheckOutButton();
		
		info.getDiscount(couponCode);
		
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
		
	}
	
	@AfterMethod
	public void logOut() {
		
		openLandingPage();
		
		landing.clickOnAccountLink();

		myAccount.clickOnLogout();	
		
	}

	@AfterClass
	public void tearDown() {
		
		driver.quit();	
		
	}

}
