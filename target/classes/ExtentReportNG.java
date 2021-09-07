package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent ;
	
	public static ExtentReports getExtentReportObject() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(Base.path+"/reports/index.html");
		reporter.config().setReportName("Gili Products Automation Suite Report");
		reporter.getConf().setDocumentTitle("Gili Products Automation Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Subhash Bhatewera");
		return extent ;
	}

}
