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
	
	@DataProvider(name="Coupon Code Order Data")
	public  Object[][] womenPantsData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "WomensPant");
		Object data[][] = excel.getData();
		return data;
	}
	
	@DataProvider(name="Womens Tops Data")
	public  Object[][] womenTopsData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "WomensTops");
		Object data[][] = excel.getData();
		return data;
	}
	
	@DataProvider(name="Outerwear Data")
	public  Object[][] outerwearData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "Outerwear");
		Object data[][] = excel.getData();
		return data;
	}
	
	@DataProvider(name="Skirts Data")
	public  Object[][] skirtsData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "Skirts");
		Object data[][] = excel.getData();
		return data;
	}
	
	@DataProvider(name="Scarves Data")
	public  Object[][] scarvesData() {
		excel = new ExcelReader(Base.path+"/TestData.xlsx", "Scarves");
		Object data[][] = excel.getData();
		return data;
	}
}
