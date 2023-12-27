package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage {
  public  WebDriver driver;	  
	
	
    public MyAccountpage( WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements( driver,this);
    	
    }
    @FindBy(xpath="//a[contains(text(),'Edit your account information')]")
    WebElement Editinfofeild;


	public WebElement getEditinfofeild() {
		return Editinfofeild;
	}

}
