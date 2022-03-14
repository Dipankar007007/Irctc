package IrctcTicketBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePageObjectPattern {
	
	WebDriver driver;

	public HomePagePageObjectPattern(WebDriver driver)
	{
		this.driver=driver;
	}	
		By alert=By.xpath("//button[@class='btn btn-primary']");
		By login=By.xpath("//a[@class='search_btn loginText ng-star-inserted']");
		
		public WebElement Alert()
		{
			return driver.findElement(alert);
		}
		public WebElement Login()
		{
			return driver.findElement(login);
		}
	}


