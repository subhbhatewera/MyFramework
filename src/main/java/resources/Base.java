package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver driver;
	public static String path = System.getProperty("user.dir");
	public Properties prop ;
	
	public WebDriver invokeBrowser() {
		try {
		FileInputStream fis = new FileInputStream(path+"/config.properties");
		prop = new Properties();
		prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", path+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver ;
	}
	
	public String getScreenshot(WebDriver driver, String testName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String target = path+"/reports/screenshots/"+testName+".png" ;
		try {		
		FileUtils.copyFile(src, new File(target));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return target ;
	}

}
