package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;
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
		log.info("YourCartPage object created");
		Base.logExtentReport("YourCartPage object created");
	}
	
	public void clickOnRemoveButton() {
		log.info("Waiting for visibility of removeButton");
		Base.logExtentReport("Waiting for visibility of removeButton");
		reuseable.waitForVisibility(removeButton);
		log.info("Click on removeButton");
		Base.logExtentReport("lick on removeButton");
		removeButton.click();
	}
	
	public void clickOnUpdateButton() {
		log.info("Waiting for visibility of updateButton");
		Base.logExtentReport("Waiting for visibility of updateButton");
		reuseable.waitForVisibility(updateButton);
		log.info("Click on updateButton");
		Base.logExtentReport("Click on updateButton");
		updateButton.click();
	}
	
	public InformationPage clickOnCheckOutButton() {
		log.info("Waiting for visibility of checkOutButton");
		Base.logExtentReport("Waiting for visibility of checkOutButton");
		reuseable.waitForVisibility(checkOutButton);
		log.info("Click on checkOutButton");
		Base.logExtentReport("Click on checkOutButton");
		checkOutButton.click();
		return new InformationPage(driver);
	}
	
	public void enterQuantity(String quantity) {
		log.info("Waiting for visibility of quantityTextField");
		Base.logExtentReport("Waiting for visibility of quantityTextField");
		reuseable.waitForVisibility(quantityTextField);
		log.info("Enter data in quantityTextField");
		Base.logExtentReport("Enter data in quantityTextField");
		quantityTextField.clear();
		quantityTextField.sendKeys(quantity);
	}

}
