package IrctcTicketBooking;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//span[text()='Welcome Pritam Singh (pris006)']")
	 private WebElement welcometext;
	
	@FindBy(css="[aria-label*='Enter From station'] input")
	private WebElement Origin;
	
	@FindBy(css="[role='option']")
    private List<WebElement> OriginStation;	
	
	@FindBy(css="[aria-label*='Enter To station'] input")
	private WebElement Destination;
	
	@FindBy(css="[role='option']")
    private List<WebElement> DestinationStation;	
	
	@FindBy(xpath="//*[@id='journeyQuota']/div/div[3]")
	private WebElement JourneyQuota;
	
	
	@FindBy(xpath="//span[text()='TATKAL']")
	private WebElement Tatkal;
	
	@FindBy(xpath="//span[contains(@class,'ui-calendar')]/input")
	private WebElement Date;
	
	By Calender=By.xpath("//div[contains(@class,'ui-datepicker-group')]");
	
	//@FindBy(xpath="//div[contains(@class,'ui-datepicker-group')]")
	//private WebElement Calender;
	
	By Month=By.xpath("//span[contains(@class,'ui-datepicker-month')]");
	//@FindBy(xpath="//span[contains(@class,'ui-datepicker-month')]")
	//private WebElement Month;
	
	By Year=By.xpath("//span[contains(@class,'ui-datepicker-year')]");
	
	//@FindBy(xpath="//span[contains(@class,'ui-datepicker-year')]")
	//private WebElement Year;
	
	
	public WebElement landingPage()
	{
		return welcometext;
	}
	
	public WebElement getOrigin()
	{
		return Origin;
	}
	
	public List<WebElement> getOriginStation()
	{
		return OriginStation;
	}
	
	public WebElement getDestination()
	{
		return Destination;	
	}
	
	public List<WebElement> getDestinationStation(){
		return DestinationStation;
		
	}
		
	public WebElement setJourneyQuota()
	{
		return JourneyQuota;
	}
		
	public WebElement setTatkal()
	{
		return Tatkal;
	}	
	public WebElement selectDate()
	{
	  	return Date;
	  	
	}
	
	public WebElement selectCalender()
	{
	   return driver.findElement(Calender);
	}
	public WebElement selectMonth()
	{
		return selectCalender().findElement(Month);
		
	}
	
	public WebElement selectYear()
	{
		return selectCalender().findElement(Year);
		
	}
}
