package util;

import org.testng.annotations.DataProvider;

import resources.Base;

public class ReadData {

	ExcelReader excel ;

	@DataProvider(name="credentials")
	public  Object[][] loginData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "Credentials");
		Object data[][] = excel.getData();
		return data;
	}

	@DataProvider(name="Simple Order Data")
	public  Object[][] mensPantsData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "MensPant");
		Object data[][] = excel.getData();
		return data;
	}
	
	@DataProvider(name="Multiple Quantity Order Data")
	public  Object[][] mensTopsData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "MensTop");
		Object data[][] = excel.getData();
		return data;
	}
}
