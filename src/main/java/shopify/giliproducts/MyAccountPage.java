package shopify.giliproducts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ReuseableMethods;

public class MyAccountPage {
	
	WebDriver driver ;
	ReuseableMethods reusable ;
	
	@FindBy(css = "#customer_logout_link")
	WebElement logoutLink;
	
	@FindBy(xpath = "(//div[contains(@class,'one-third')] //p)[1]")
	WebElement addressDetails;
	
	Logger log = LogManager.getLogger(MyAccountPage.class.getName());
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		reusable = new ReuseableMethods(driver);
	}
	
	public void clickOnLogout() {
		log.debug("Waiting for visibility of logoutLink");
		reusable.waitForVisibility(logoutLink);
		log.debug("Click on logoutLink");
		logoutLink.click();
	}
	
	public boolean validateCustomerName(String customerName) {
		boolean flag = false;
		log.debug("Waiting for visibility of addressDetails");
		reusable.waitForVisibility(addressDetails);
		String address = addressDetails.getText();
		if(address.contains(customerName))
			flag = true;
		return flag ;
	}

}
