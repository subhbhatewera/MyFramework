package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;
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
		log.info("LandingPage object created");
		Base.logExtentReport("LandingPage object created");
	}

	public ProductsPage clickOnMensPantsLink() {
		log.info("Waiting for visibility of mensPantsLink");
		Base.logExtentReport("Waiting for visibility of mensPantsLink");
		reuseable.waitForVisibility(mensPantsLink);
		log.info("Click on mensPantsLink");
		Base.logExtentReport("Click on mensPantsLink");
		mensPantsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnMensTopsLink() {
		log.info("Waiting for visibility of mensTopsLink");
		Base.logExtentReport("Waiting for visibility of mensTopsLink");
		reuseable.waitForVisibility(mensTopsLink);
		log.info("Click on mensTopsLink");
		Base.logExtentReport("Click on mensTopsLink");
		mensTopsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnWomensPantsLink() {
		log.info("Waiting for visibility of womenPantsLink");
		Base.logExtentReport("Waiting for visibility of womenPantsLink");
		reuseable.waitForVisibility(womenPantsLink);
		log.info("Click on womenPantsLink");
		Base.logExtentReport("Click on womenPantsLink");
		womenPantsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnWomensTopsLink() {
		log.info("Waiting for visibility of womenTopsLink");
		Base.logExtentReport("Waiting for visibility of womenTopsLink");
		reuseable.waitForVisibility(womenTopsLink);
		Base.logExtentReport("Click on womenTopsLink");
		log.info("Click on womenTopsLink");
		womenTopsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnOuterwearLink() {
		log.info("Waiting for visibility of outerwearLink");
		Base.logExtentReport("Waiting for visibility of outerwearLink");
		reuseable.waitForVisibility(outerwearLink);
		log.info("Click on outerwearLink");
		Base.logExtentReport("Click on outerwearLink");
		outerwearLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnSkirtsLink() {
		log.info("Waiting for visibility of skirtsLink");
		Base.logExtentReport("Waiting for visibility of skirtsLink");
		reuseable.waitForVisibility(skirtsLink);
		log.info("Click on skirtsLink");
		Base.logExtentReport("Click on skirtsLink");
		skirtsLink.click();
		return new ProductsPage(driver);
	}
	
	public ProductsPage clickOnScarvesLink() {
		log.info("Waiting for visibility of scarvesLink");
		Base.logExtentReport("Waiting for visibility of scarvesLink");
		reuseable.waitForVisibility(scarvesLink);
		log.info("Click on scarvesLink");
		Base.logExtentReport("Click on scarvesLink");
		scarvesLink.click();
		return new ProductsPage(driver);
	}
	
	public LoginPage clickOnLoginLink() {
		log.info("Waiting for visibility of loginLink");
		Base.logExtentReport("Waiting for visibility of loginLink");
		reuseable.waitForVisibility(loginLink);
		log.info("Click on loginLink");
		Base.logExtentReport("Click on loginLink");
		loginLink.click();
		return new LoginPage(driver);
	}
	
	public MyAccountPage clickOnAccountLink() {
		log.info("Waiting for visibility of accountLink");
		Base.logExtentReport("Waiting for visibility of accountLink");
		reuseable.waitForVisibility(accountLink);
		log.info("Click on accountLink");
		Base.logExtentReport("Click on accountLink");
		accountLink.click();
		return new MyAccountPage(driver);
	}
}
