package shopify.giliproducts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	
	WebDriver driver;
	
	@FindBy(id = "shipping-rates__title")
	WebElement spinner;
	
	@FindBy(css = "[class*='radio'] span[class*='pr']")
	List<WebElement> shippingRatesList ;
	
	@FindBy(css = "#continue_button")
	WebElement continueToPaymentButton;
	
	@FindBy(css = "a[class*='previous']")
	WebElement returnToInformationLink;
	
	public ShippingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
