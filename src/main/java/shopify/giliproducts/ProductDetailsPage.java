package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;
import util.ReuseableMethods;

public class ProductDetailsPage {
	
	WebDriver driver;
	ReuseableMethods reuseable ;
	
	@FindBy(css = "[id*='AddToCart-']")
	WebElement addToCartButton;
	
	@FindBy(css = "[id*='SingleOptionSelector']")
	WebElement optionsDropDown;
	
	Logger log = LogManager.getLogger(ProductDetailsPage.class.getName());
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
		log.info("ProductDetailsPage object created");
		Base.logExtentReport("ProductDetailsPage object created");
	}
	
	public YourCartPage clickOnAddToCartButton() {
		log.info("Waiting for visibility of addToCartButton");
		Base.logExtentReport("Waiting for visibility of addToCartButton");
		reuseable.waitForVisibility(addToCartButton);
		addToCartButton.click();
		log.info("Click on addToCartButton");
		Base.logExtentReport("Click on addToCartButton");
		return new YourCartPage(driver);
	}

}
