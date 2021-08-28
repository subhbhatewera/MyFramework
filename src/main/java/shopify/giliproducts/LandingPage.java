package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver ;
	
	@FindBy(xpath = "//ul[@id='SiteNav'] //a[contains(@href,'mens-jeans')]")
	WebElement mensPantsLink ;
	
	@FindBy(xpath = "//ul[@id='SiteNav'] //a[contains(@href,'mens-tops')]")
	WebElement mensTopsLink ;
	
	@FindBy(xpath = "//ul[@id='SiteNav'] //a[contains(@href,'womens-jeans')]")
	WebElement womenPantsLink ;
	
	@FindBy(xpath = "//ul[@id='SiteNav'] //a[contains(@href,'womens-tops')]")
	WebElement womenTopsLink ;
	
	@FindBy(xpath = "//ul[@id='SiteNav'] //a[contains(@href,'outerwear')]")
	WebElement outerwearLink ;
	
	@FindBy(xpath = "//ul[@id='SiteNav'] //a[contains(@href,'skirts')]")
	WebElement skirtsLink ;
	
	@FindBy(xpath = "//ul[@id='SiteNav'] //a[contains(@href,'scarves')]")
	WebElement scarvesLink ;
	
	@FindBy(xpath = "//a[contains(@href,'login')]")
	WebElement loginLink ;
	
	@FindBy(xpath = "//a[contains(@href,'account')]")
	WebElement accountLink ;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	

}
