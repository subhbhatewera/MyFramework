package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ReuseableMethods;

public class InformationPage {
	
	WebDriver driver;
	ReuseableMethods reuseable;
	
	@FindBy(css = "#continue_button")
	WebElement continueToShippingButton;
	
	@FindBy(css = "a[class*='previous']")
	WebElement returnToCartLink;
	
	@FindBy(id = "checkout_reduction_code")
	WebElement giftCardTextField;
	
	@FindBy(css = "[class='field__input-btn btn']")
	WebElement applyButton;
	
	Logger log = LogManager.getLogger(InformationPage.class.getName());
	
	public InformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
	}
	
	public void enterGiftCard(String giftCard) {
		log.debug("Waiting for visibility of giftCardTextField");
		reuseable.waitForVisibility(giftCardTextField);
		log.debug("Enter data in giftCardTextField");
		giftCardTextField.sendKeys(giftCard);
	}
	
	public void clickOnApplyButton() {
		log.debug("Waiting for visibility of applyButton");
		reuseable.waitForVisibility(applyButton);
		log.debug("Click on applyButton");
		applyButton.click();
	}
	
	public ShippingPage clickOnContinueToShippingButton() {
		log.debug("Waiting for visibility of continueToShippingButton");
		reuseable.waitForVisibility(continueToShippingButton);
		log.debug("Click on continueToShippingButton");
		continueToShippingButton.click();
		return new ShippingPage(driver);
	}
	
	public YourCartPage clickOnReturnToCartLink() {
		log.debug("Waiting for visibility of returnToCartLink");
		reuseable.waitForVisibility(returnToCartLink);
		log.debug("Click on returnToCartLink");
		returnToCartLink.click();
		return new YourCartPage(driver);
	}

}
