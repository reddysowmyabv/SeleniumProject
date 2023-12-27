package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.management.openmbean.OpenType;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		  prop = new Properties();
		 String path = System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties";
		 FileInputStream fis = new FileInputStream(path);
		 prop.load(fis);
		 
		String browser ="chrome";
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public void takrscreenshot(String testName,WebDriver driver) throws IOException {
		File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String despath=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
	File destfile = new File(despath);
		FileUtils.copyFile(Src, destfile);
	}
	
}

