package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
	
	WebDriver driver;
	
	@FindBy(css = "p [class*='cart__remove']")
	WebElement removeButton;
	
	@FindBy(css = ".cart__qty-input")
	WebElement quantityTextField;
	
	@FindBy(css = "[class*='cart__update--']")
	WebElement updateButton;
	
	@FindBy(css = "[value='Check out']")
	WebElement checkOutButton;
	
	public YourCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
