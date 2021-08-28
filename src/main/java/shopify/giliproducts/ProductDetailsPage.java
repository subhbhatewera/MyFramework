package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	WebDriver driver;
	
	@FindBy(css = "[id*='AddToCart-']")
	WebElement addToCartButton;
	
	@FindBy(css = "[id*='SingleOptionSelector']")
	WebElement optionsDropDown;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
