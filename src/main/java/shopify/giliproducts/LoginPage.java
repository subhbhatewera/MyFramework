package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver ;
	
	@FindBy(css = "#CustomerEmail")
	WebElement emailTextField ;
	
	@FindBy(css = "[type='password']")
	WebElement passwordTextField ;
	
	@FindBy(css = "[value='Sign In']")
	WebElement signInButtton ;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

}
