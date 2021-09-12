package shopify.giliproducts;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class ProductsPage {

	WebDriver driver ;

	@FindBy(css = "[class*='item__title']")
	List<WebElement> productList ;
	
	Logger log = LogManager.getLogger(ProductsPage.class.getName());

	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		log.info("ProductsPage object created");
		Base.logExtentReport("ProductsPage object created");
	}

	public void selectProduct(String[] requiredProducts) {
		List<String> requiredProductsList = Arrays.asList(requiredProducts);
		int count = 0 ;
		int i = 0 ;
		for(WebElement option : productList) {
			String productName = option.getText();
			if(requiredProductsList.contains(productName)) {
				productList.get(count).click();
				i++;
				if(i==requiredProductsList.size()) {
					break;
				}
			}
			count++;
		}
	}
	
	public ProductDetailsPage selectProduct(String requiredProductName) {
		int count = 0 ;
		for(WebElement option : productList) {			
			String actualProductName = option.getText();
			if(actualProductName.equalsIgnoreCase(requiredProductName)) {
				productList.get(count).click();
				log.info("Select Product "+actualProductName);
				Base.logExtentReport("Select Product "+actualProductName);
				break;
			}
			count++;
		}
		return new ProductDetailsPage(driver);
	}

}
