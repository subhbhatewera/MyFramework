package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;
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
		log.info("PaymentPage object created");
		Base.logExtentReport("PaymentPage object created");
	}
	
	public void enterCardNumber(String cardNumber) {		
		WebElement cardNumberFrame = driver.findElement(By.cssSelector("[id*='card-fields-number']"));
		log.info("Waiting for visibility of cardNumberFrame");
		Base.logExtentReport("Waiting for visibility of cardNumberFrame");
		reuseable.waitForVisibility(cardNumberFrame);	
		log.info("Switch to cardNumberFrame");
		Base.logExtentReport("Switch to cardNumberFrame");
		driver.switchTo().frame(cardNumberFrame);
		log.info("Enter "+cardNumber+" in cardNumberTextField");	
		Base.logExtentReport("Enter "+cardNumber+" in cardNumberTextField");
		reuseable.enterData(cardNumberTextField, cardNumber);
		log.info("Switch to default Content");	
		Base.logExtentReport("Switch to default Content");
		driver.switchTo().defaultContent();
	}
	
	public void enterName(String name) {
		WebElement nameFrame = driver.findElement(By.cssSelector("[id*='card-fields-name']")); 
		log.info("Switch to nameFrame");
		Base.logExtentReport("Switch to nameFrame");
		driver.switchTo().frame(nameFrame);
		log.info("Enter "+name+" in nameOnCardTextField");
		Base.logExtentReport("Enter "+name+" in nameOnCardTextField");
		nameOnCardTextField.sendKeys(name);
		log.info("Switch to default Content");	
		Base.logExtentReport("Switch to default Content");
		driver.switchTo().defaultContent();
	}
	
	public void enterExpirationDate(String expiryDate) {
		WebElement expiryFrame = driver.findElement(By.cssSelector("[id*='card-fields-expiry']")); 
		log.info("Switch to expiryFrame");
		Base.logExtentReport("Switch to expiryFrame");
		driver.switchTo().frame(expiryFrame);
		log.info("Enter "+expiryDate+" in expirationDateTextField");
		Base.logExtentReport("Enter "+expiryDate+" in expirationDateTextField");
		reuseable.enterData(expirationDateTextField, expiryDate);	
		log.info("Switch to default Content");	
		Base.logExtentReport("Switch to default Content");
		driver.switchTo().defaultContent();		
	}
	
	public void enterSecutiryCode(String code) {
		WebElement secutiryFrame = driver.findElement(By.cssSelector("[id*='card-fields-verification']"));
		log.info("Switch to secutiryFrame");
		Base.logExtentReport("Switch to secutiryFrame");
		driver.switchTo().frame(secutiryFrame);
		log.info("Enter "+code+" in securityCodeTextField");
		Base.logExtentReport("Enter "+code+" in securityCodeTextField");
		securityCodeTextField.sendKeys(code);
		log.info("Switch to default Content");	
		Base.logExtentReport("Switch to default Content");
		driver.switchTo().defaultContent();		
	}
	
	public OrderConfirmationPage clickOnPayNowBtn() {
		log.info("Click on payNowButton");
		Base.logExtentReport("Click on payNowButton");
		reuseable.mySleep(1000);
		payNowButton.click();
		return new OrderConfirmationPage(driver);
	}

}
