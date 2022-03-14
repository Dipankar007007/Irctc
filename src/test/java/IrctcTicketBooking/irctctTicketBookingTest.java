package IrctcTicketBooking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import utility.Xls_Reader;

public class irctctTicketBookingTest {

	String ClassName = LogManager.class.getName();
	Logger log = LogManager.getLogger(ClassName);

	@Parameters("URL")
	@Test()
	public void BookTicket(String Url) throws InterruptedException, MalformedURLException {

		System.setProperty("webdriver.chrome.driver", "E:\\Apps\\chromedriver\\chromedriver.exe");
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(ch);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get(Url);

		driver.navigate().to(Url);
		log.info("Page is Loaded");
		HomePagePageObjectPattern homepage = new HomePagePageObjectPattern(driver);
		homepage.Alert().click();
		homepage.Login().click();
		LoginPagePageObjectPattern loginpage = new LoginPagePageObjectPattern(driver);
		loginpage.UserId().sendKeys("pris006");
		loginpage.Password().sendKeys("Lionsingh007007");

		// loginpage.getSignIn().click();
		log.info("SignIn button Clicked");

		WebDriverWait wait = new WebDriverWait(driver, 50);
		LandingPage lp = new LandingPage(driver);
		wait.until(ExpectedConditions.visibilityOf(lp.landingPage()));
		lp.getOrigin().click();

		Xls_Reader r = new Xls_Reader("C:\\Users\\Asus\\Desktop\\BookingDaetails.xlsx");

		String Origin = r.getCellData("BookingInformation", "From", 2);
		System.out.println(Origin);

		List<WebElement> OriginStationList = lp.getOriginStation();

		for (int i = 0; i < OriginStationList.size(); i++) {
			String StationName = OriginStationList.get(i).getText();
			if (StationName.equalsIgnoreCase(Origin))

			{
				OriginStationList.get(i).click();
				break;

			}

		}

		lp.getDestination().click();

		String Destination = r.getCellData("BookingInformation", "To", 2);
		System.out.println("i m reacing here");

		List<WebElement> DestinationStationList = lp.getDestinationStation();

		for (int j = 0; j < DestinationStationList.size(); j++) {
			String DesStationName = DestinationStationList.get(j).getText();
			System.out.println(DesStationName);
			if (DesStationName.equalsIgnoreCase("Destination"))

			{
				//System.out.println(DesStationName);
				//System.out.println(Destination);
				DestinationStationList.get(j).click();
				break;

			}
		}
		
		lp.setJourneyQuota().click();
		
		Actions a=new Actions(driver);
		a.moveToElement(lp.setTatkal()).click().build().perform();
		
		lp.selectDate().click();
		
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.visibilityOf(lp.selectYear()));
		
		System.out.println(lp.selectMonth().getText());
		
		
		
	}
	}