package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver driver ;
	
	@FindBy(css = "[placeholder='Card number']")
	WebElement cardNumberTextField;
	
	@FindBy(css = "[placeholder*='Name']")
	WebElement nameOnCardTextField;
	
	@FindBy(css = "[placeholder*='Exp']")
	WebElement expirationDateTextField;
	
	@FindBy(css = "[placeholder*='Sec']")
	WebElement securityCodeTextField;
	
	@FindBy(css = "[class*='shown'] #continue_button")
	WebElement continueToPaymentButton;
	
	@FindBy(css = "a[class*='previous']")
	WebElement returnToShippingLink;
	
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
