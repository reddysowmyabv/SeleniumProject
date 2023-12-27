package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
 public WebDriver driver;

 public Landingpage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	 
 }
  @FindBy(xpath="//a[@title='My Account']")
   WebElement myAccDropDown;
  
  @FindBy (xpath="//a[contains(text(),'Login')]")
  WebElement loginOption;

public WebElement getMyAccDropDown() {
	return myAccDropDown;
}

public WebElement getLoginOption() {
	return loginOption;
}
  
}
