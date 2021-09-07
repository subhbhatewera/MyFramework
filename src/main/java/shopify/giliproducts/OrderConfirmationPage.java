package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ReuseableMethods;

public class OrderConfirmationPage {
	
	WebDriver driver;
	ReuseableMethods reuseable;
	
	@FindBy(css = "div h2[id='main-header']")
	WebElement thankYouTextLabel;
	
	@FindBy(css = "div span[class*='number']")
	WebElement orderNumberLabel;
	
	@FindBy(css = "[class*='continue-btn btn']")
	WebElement continueShoppingButton;
	
	Logger log = LogManager.getLogger(OrderConfirmationPage.class.getName());
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reuseable=new ReuseableMethods(driver);
	}
	
	public String getOrderConfirmation() {
		log.debug("Waiting for visibility of orderNumberLabel");
		reuseable.waitForVisibility(orderNumberLabel);
		String labelText = thankYouTextLabel.getText();
		String formatedText =labelText.substring(0, 9);
		return formatedText;
	}
	
	public String getOrderNumber() {
		log.debug("Waiting for visibility of orderNumberLabel");
		reuseable.waitForVisibility(orderNumberLabel);
		String labelText = orderNumberLabel.getText();
		String orderNumber = labelText.substring(6);
		return orderNumber;
	}
	
	public LandingPage clickOnContinueShoppingButton() {
		log.debug("Waiting for visibility of continueShoppingButton");
		reuseable.waitForVisibility(continueShoppingButton);
		log.debug("Click on continueShoppingButton");
		continueShoppingButton.click();
		return new LandingPage(driver);
	}

}
