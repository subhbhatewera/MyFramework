package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;
import util.ReuseableMethods;

public class LoginPage {
	
	WebDriver driver ;	
	ReuseableMethods reuseable ;
	
	@FindBy(css = "#CustomerEmail")
	WebElement emailTextField ;
	
	@FindBy(css = "[type='password']")
	WebElement passwordTextField ;
	
	@FindBy(css = "[value='Sign In']")
	WebElement signInButtton ;
	
	Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public LoginPage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
		log.info("LoginPage object created");
		Base.logExtentReport("LoginPage object created");
	}
	
	public void enterEmail(String email) {
		log.info("Waiting for visibility of emailTextField");
		Base.logExtentReport("Waiting for visibility of emailTextField");
		reuseable.waitForVisibility(emailTextField);
		log.info("Enter "+email+ " in emailTextField");
		Base.logExtentReport("Enter "+email+ " in emailTextField");
		emailTextField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		log.info("Waiting for visibility of passwordTextField");
		Base.logExtentReport("Waiting for visibility of passwordTextField");
		reuseable.waitForVisibility(passwordTextField);
		log.info("Enter data in passwordTextField");
		Base.logExtentReport("Enter data in passwordTextField");
		passwordTextField.sendKeys(password);
	}
	
	public MyAccountPage clickOnSigninButton() {
		log.info("Waiting for visibility of signInButtton");
		Base.logExtentReport("Waiting for visibility of signInButtton");
		reuseable.waitForVisibility(signInButtton);
		log.info("Click on signInButtton");
		Base.logExtentReport("Click on signInButtton");
		signInButtton.click();
		return new MyAccountPage(driver);
	}
	
	public MyAccountPage doLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickOnSigninButton();
		return new MyAccountPage(driver);
	}

}
