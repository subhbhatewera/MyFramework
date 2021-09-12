package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base {
	
	public static WebDriver driver;
	public static String path = System.getProperty("user.dir");
	public Properties prop ;
	public static ExtentReports extent ;
	public static ExtentTest test;
	private Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentReportNG.createInstance();
	}
	
	@BeforeTest
	public void beforeTest() {
		test = extent.createTest(getClass().getSimpleName()).assignAuthor("Subhash");
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName());
		log.info(method.getName() +" : Action started ");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(getScreenshot(driver, testName), testName);		
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, testName);
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
			test.addScreenCaptureFromPath(getScreenshot(driver, testName), testName);
		}
		extent.flush();
	}
	
	public static void logExtentReport(String msg) {
		Base.test.log(Status.INFO, msg);
	}
	
	public WebDriver invokeBrowser() {
		try {
		FileInputStream fis = new FileInputStream(path+"/config.properties");
		prop = new Properties();
		prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser").toLowerCase();
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", path+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
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
