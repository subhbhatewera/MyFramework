package shopify.giliproducts;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ReuseableMethods;

public class ShippingPage {
	
	WebDriver driver;
	ReuseableMethods reuseable ;
	
	@FindBy(id = "shipping-rates__title")
	WebElement spinner;
	
	@FindBy(css = "[class*='radio'] span[class*='pr']")
	List<WebElement> shippingRatesList ;
	
	@FindBy(css = "#continue_button")
	WebElement continueToPaymentButton;
	
	@FindBy(css = "a[class*='previous']")
	WebElement returnToInformationLink;
	
	Logger log = LogManager.getLogger(ShippingPage.class.getName());
	
	public ShippingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
	}
	
	public void selectShipping(String requiredShipping) {
		log.debug("Waiting for Shipping Rates");
		reuseable.waitForClickable(continueToPaymentButton);
		int count = 0 ;		
		for(WebElement option : shippingRatesList) {
			String actualShipping = option.getText();			
			if(actualShipping.contains(requiredShipping)) {
				shippingRatesList.get(count).click();
				log.debug("Select Shipping "+actualShipping);
				break ;
			}
			count++;
		}
	}
	
	public PaymentPage clickOnContinueToPaymentButton() {
		log.debug("Waiting for visibility of continueToPaymentButton");
		reuseable.waitForVisibility(continueToPaymentButton);
		log.debug("Click on continueToPaymentButton");
		continueToPaymentButton.click();
		return new PaymentPage(driver);
	}
	

}
