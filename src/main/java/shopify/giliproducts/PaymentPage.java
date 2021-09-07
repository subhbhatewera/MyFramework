package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ReuseableMethods;

public class PaymentPage  {
	
	WebDriver driver ;	
	ReuseableMethods reuseable;
	
	@FindBy(css = "[placeholder='Card number']")
	WebElement cardNumberTextField;
	
	@FindBy(css = "[placeholder*='Name']")
	WebElement nameOnCardTextField;
	
	@FindBy(css = "[placeholder*='Exp']")
	WebElement expirationDateTextField;
	
	@FindBy(css = "[placeholder*='Sec']")
	WebElement securityCodeTextField;
	
	@FindBy(css = "[class*='shown'] #continue_button")
	WebElement payNowButton;
	
	@FindBy(css = "a[class*='previous']")
	WebElement returnToShippingLink;
	
	Logger log = LogManager.getLogger(PaymentPage.class.getName());	
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
	}
	
	public void enterCardNumber(String cardNumber) {		
		WebElement cardNumberFrame = driver.findElement(By.cssSelector("[id*='card-fields-number']"));
		log.debug("Waiting for visibility of cardNumberFrame");
		reuseable.waitForVisibility(cardNumberFrame);	
		log.debug("Switch to cardNumberFrame");
		driver.switchTo().frame(cardNumberFrame);
		log.debug("Enter data in cardNumberTextField");		
		reuseable.enterData(cardNumberTextField, cardNumber);
		log.debug("Switch to default Content");	
		driver.switchTo().defaultContent();
	}
	
	public void enterName(String name) {
		WebElement nameFrame = driver.findElement(By.cssSelector("[id*='card-fields-name']")); 
		log.debug("Switch to nameFrame");
		driver.switchTo().frame(nameFrame);
		log.debug("Enter data in nameOnCardTextField");
		nameOnCardTextField.sendKeys(name);
		log.debug("Switch to default Content");	
		driver.switchTo().defaultContent();
	}
	
	public void enterExpirationDate(String expiryDate) {
		WebElement expiryFrame = driver.findElement(By.cssSelector("[id*='card-fields-expiry']")); 
		log.debug("Switch to expiryFrame");
		driver.switchTo().frame(expiryFrame);
		log.debug("Enter data in expirationDateTextField");
		reuseable.enterData(expirationDateTextField, expiryDate);	
		log.debug("Switch to default Content");	
		driver.switchTo().defaultContent();		
	}
	
	public void enterSecutiryCode(String code) {
		WebElement secutiryFrame = driver.findElement(By.cssSelector("[id*='card-fields-verification']"));
		log.debug("Switch to secutiryFrame");
		driver.switchTo().frame(secutiryFrame);
		log.debug("Enter data in securityCodeTextField");
		securityCodeTextField.sendKeys(code);
		log.debug("Switch to default Content");	
		driver.switchTo().defaultContent();		
	}
	
	public OrderConfirmationPage clickOnPayNowBtn() {
		log.debug("Click on payNowButton");
		payNowButton.click();
		return new OrderConfirmationPage(driver);
	}

}
