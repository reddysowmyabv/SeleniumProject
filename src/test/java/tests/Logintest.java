package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Landingpage;
import PageObjects.Loginpage;
import PageObjects.MyAccountpage;
import resource.Base;
import resource.ExcelReader;

public class Logintest extends Base {
	public WebDriver driver;
	@BeforeMethod
	public void openApp() throws IOException {
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getlogindata")
	public void login(String email,String password,String excepcted) throws IOException {
	
	Landingpage lp = new Landingpage(driver);
	lp.getMyAccDropDown().click();
	lp.getLoginOption().click();

	Loginpage log = new Loginpage(driver);
	log.getEmailFeild().sendKeys(email);
	log.getPasswordFeild().sendKeys(password);
	log.getLoginfeild().click();
	 
	
	MyAccountpage map = new MyAccountpage(driver);
	String actual=null;
	try {
	if(map.getEditinfofeild().isDisplayed()) {
		actual="success";
	}	
}
   catch(Exception e) {
	actual="failure";
   }
	Assert.assertEquals(actual,excepcted);

	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getlogindata() throws IOException {
		ExcelReader reader = new ExcelReader();
		Object[][] data=reader.excelRead();
		return data;
		
		}
}