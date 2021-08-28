package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver driver ;
	
	@FindBy(css = "#customer_logout_link")
	WebElement logoutLink;
	
	@FindBy(xpath = "(//div[contains(@class,'one-third')] //p)[1]")
	WebElement addressDetails;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
