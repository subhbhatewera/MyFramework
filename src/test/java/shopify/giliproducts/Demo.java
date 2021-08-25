package shopify.giliproducts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class Demo extends Base{
	
	WebDriver driver ;
	
	@Test
	public void test() {
		driver = invokeBrowser();
		driver.get("http://google.com");
	}

}
