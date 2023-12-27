package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resource.Base;

public class ClassThree extends Base{
	public WebDriver driver;
@Test
	public void classtreetest() throws IOException {
		 driver= initializeDriver();
		driver.get("https://surendrareddy1248.github.io/WebElementsTesting/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}


