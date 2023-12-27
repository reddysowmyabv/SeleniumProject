package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
 public WebDriver driver;
   
  public Loginpage(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	  	  
  }
  @FindBy(xpath="//input[@id='input-email']")
  WebElement emailFeild;
  
  @FindBy(xpath="//input[@id='input-password']")
  WebElement passwordFeild;
  
  @FindBy(xpath="//input[@value=\"Login\"]")
  WebElement loginfeild;

public WebElement getEmailFeild() {
	return emailFeild;
}

public WebElement getPasswordFeild() {
	return passwordFeild;
}

public WebElement getLoginfeild() {
	return loginfeild;
}
	
	

}
