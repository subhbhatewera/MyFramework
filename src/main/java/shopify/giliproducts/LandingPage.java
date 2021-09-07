package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ReuseableMethods;

public class LandingPage {

	WebDriver driver ;
	ReuseableMethods reuseable ;

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
	
	Logger log = LogManager.getLogger(LandingPage.class.getName());

	public LandingPage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
	}

	public ProductsPage clickOnMensPantsLink() {
		log.debug("Waiting for visibility of mensPantsLink");
		reuseable.waitForVisibility(mensPantsLink);
		log.debug("Click on mensPantsLink");
		mensPantsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnMensTopsLink() {
		log.debug("Waiting for visibility of mensTopsLink");
		reuseable.waitForVisibility(mensTopsLink);
		log.debug("Click on mensTopsLink");
		mensTopsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnWomensPantsLink() {
		log.debug("Waiting for visibility of womenPantsLink");
		reuseable.waitForVisibility(womenPantsLink);
		log.debug("Click on womenPantsLink");
		womenPantsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnWomensTopsLink() {
		log.debug("Waiting for visibility of womenTopsLink");
		reuseable.waitForVisibility(womenTopsLink);
		log.debug("Click on womenTopsLink");
		womenTopsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnOuterwearLink() {
		log.debug("Waiting for visibility of outerwearLink");
		reuseable.waitForVisibility(outerwearLink);
		log.debug("Click on outerwearLink");
		outerwearLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnSkirtsLink() {
		log.debug("Waiting for visibility of skirtsLink");
		reuseable.waitForVisibility(skirtsLink);
		log.debug("Click on skirtsLink");
		skirtsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnScarvesLink() {
		log.debug("Waiting for visibility of scarvesLink");
		reuseable.waitForVisibility(scarvesLink);
		log.debug("Click on scarvesLink");
		scarvesLink.click();
		return new ProductsPage(driver);
	}
	
	public LoginPage clickOnLoginLink() {
		log.debug("Waiting for visibility of loginLink");
		reuseable.waitForVisibility(loginLink);
		log.debug("Click on loginLink");
		loginLink.click();
		return new LoginPage(driver);
	}
	
	public MyAccountPage clickOnAccountLink() {
		log.debug("Waiting for visibility of accountLink");
		reuseable.waitForVisibility(accountLink);
		log.debug("Click on accountLink");
		accountLink.click();
		return new MyAccountPage(driver);
	}
}
