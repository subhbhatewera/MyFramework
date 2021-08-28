package shopify.giliproducts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensPantsPage {
	
	WebDriver driver ;
	
	@FindBy(css = "[class*='item__title']")
	List<WebElement> productList ;
	
	public MensPantsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
