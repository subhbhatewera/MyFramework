package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
	
	WebDriver driver;
	
	@FindBy(css = "#continue_button")
	WebElement continueToShippingButton;
	
	@FindBy(css = "a[class*='previous']")
	WebElement returnToCartLink;
	
	@FindBy(id = "checkout_reduction_code")
	WebElement giftCardTextField;
	
	@FindBy(css = "[class='field__input-btn btn']")
	WebElement applyButton;
	
	public InformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
