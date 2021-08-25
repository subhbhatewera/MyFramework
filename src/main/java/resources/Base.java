package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

}
