package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;
import util.ReuseableMethods;

public class InformationPage {
	
	WebDriver driver;
	ReuseableMethods reuseable;
	
	@FindBy(css = "#continue_button")
	WebElement continueToShippingButton;
	
	@FindBy(css = "a[class*='previous']")
	WebElement returnToCartLink;
	
	@FindBy(id = "checkout_reduction_code")
	WebElement couponCodeTextField;
	
	@FindBy(css = "[class='field__input-btn btn']")
	WebElement applyButton;
	
	@FindBy(css = "[class='tag__wrapper']")
	WebElement couponCodeTag;
	
	Logger log = LogManager.getLogger(InformationPage.class.getName());
	
	public InformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);		
		log.info("Information page object created");
		Base.logExtentReport("InformationPage object created");
	}
	
	public void enterCouponCode(String couponCode) {
		log.info("Waiting for visibility of couponCodeTextField");
		Base.logExtentReport("Waiting for visibility of couponCodeTextField");
		reuseable.waitForVisibility(couponCodeTextField);		
		log.info("Enter data in couponCodeTextField");
		Base.logExtentReport("Enter data in couponCodeTextField");
		couponCodeTextField.sendKeys(couponCode);
	}
	
	public void clickOnApplyButton() {
		log.info("Waiting for visibility of applyButton");
		Base.logExtentReport("Waiting for visibility of applyButton");
		reuseable.waitForVisibility(applyButton);
		log.info("Click on applyButton");
		Base.logExtentReport("Click on applyButton");
		applyButton.click();
	}
	
	public ShippingPage clickOnContinueToShippingButton() {
		log.info("Waiting for visibility of continueToShippingButton");
		Base.logExtentReport("Waiting for visibility of continueToShippingButton");
		reuseable.waitForVisibility(continueToShippingButton);
		log.info("Click on continueToShippingButton");
		Base.logExtentReport("Click on continueToShippingButton");
		continueToShippingButton.click();
		return new ShippingPage(driver);
	}
	
	public YourCartPage clickOnReturnToCartLink() {
		log.info("Waiting for visibility of returnToCartLink");
		Base.logExtentReport("Waiting for visibility of returnToCartLink");
		reuseable.waitForVisibility(returnToCartLink);
		log.info("Click on returnToCartLink");
		Base.logExtentReport("Click on returnToCartLink");
		returnToCartLink.click();
		return new YourCartPage(driver);
	}
	
	public void validateCouponCodeTag() {
		log.info("Waitinhg for visibility of couponCodeTag");
		Base.logExtentReport("Waitinhg for visibility of couponCodeTag");
		reuseable.waitForVisibility(couponCodeTag);
	}
	
	public void getDiscount(String couponCode) {
		enterCouponCode(couponCode);
		clickOnApplyButton();
		validateCouponCodeTag();		
	}

}
