package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReuseableMethods {
	
	WebDriver driver ;
	WebDriverWait wait ;
	Actions act ;
	
	public ReuseableMethods(WebDriver driver) {
		this.driver = driver ;
	}
	
	public void waitForVisibility(WebElement element) {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForInVisibility(WebElement element) {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOf(element));
	} 
	
	public void waitForClickable(WebElement element) {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element) );
	} 
	
	public void enterData(WebElement element, String input) {
		act = new Actions(driver);
		act.moveToElement(element).click().sendKeys(input).build().perform();
	}
} 