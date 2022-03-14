package IrctcTicketBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePageObjectPattern {
	
	WebDriver driver;
	
	LoginPagePageObjectPattern(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='User Name']")
	 WebElement userId;
	
	By pwd=By.cssSelector("input[placeholder='Password']");
	
	@FindBy(className="loginError")
	  WebElement Credential;
	
	@FindBy(xpath="//*[text()='SIGN IN']")
	  WebElement SignIn;
	
	public WebElement UserId()
	{
		return userId;
	}

	public WebElement Password()
	{
		return driver.findElement(pwd);
	}
	public WebElement getCredential()
	{
		return Credential;
	}
	
	public WebElement getSignIn()
	{
		return SignIn;
	}
	
	
	
	
	

}
