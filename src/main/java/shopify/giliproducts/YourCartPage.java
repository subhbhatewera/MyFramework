package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ReuseableMethods;

public class YourCartPage {
	
	WebDriver driver;
	ReuseableMethods reuseable;
	
	@FindBy(css = "p [class*='cart__remove']")
	WebElement removeButton;
	
	@FindBy(css = ".cart__qty-input")
	WebElement quantityTextField;
	
	@FindBy(css = "[class*='cart__update--']")
	WebElement updateButton;
	
	@FindBy(css = "[value='Check out']")
	WebElement checkOutButton;
	
	Logger log = LogManager.getLogger(YourCartPage.class.getName());
	
	public YourCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
	}
	
	public void clickOnRemoveButton() {
		log.debug("Waiting for visibility of removeButton");
		reuseable.waitForVisibility(removeButton);
		log.debug("Click on removeButton");
		removeButton.click();
	}
	
	public void clickOnUpdateButton() {
		log.debug("Waiting for visibility of updateButton");
		reuseable.waitForVisibility(updateButton);
		log.debug("Click on updateButton");
		updateButton.click();
	}
	
	public InformationPage clickOnCheckOutButton() {
		log.debug("Waiting for visibility of checkOutButton");
		reuseable.waitForVisibility(checkOutButton);
		log.debug("Click on checkOutButton");
		checkOutButton.click();
		return new InformationPage(driver);
	}
	
	public void enterQuantity(String quantity) {
		log.debug("Waiting for visibility of quantityTextField");
		reuseable.waitForVisibility(quantityTextField);
		log.debug("Enter data in quantityTextField");
		quantityTextField.sendKeys(quantity);
	}

}
