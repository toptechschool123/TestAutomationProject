package selenium_lectures;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptExecutor;

public class Dates2 extends JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		



		WebDriverManager.chromedriver().setup();

	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();

		driver.get("https://www.aa.com/homePage.do");
		// driver.switchTo().alert().accept();
		// driver.manage().deleteAllCookies();

		WebElement from = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));

	
		from.click();
		from.clear();

		Thread.sleep(3000);
		from.sendKeys("seat");
		

		
		
		WebElement departFrom= driver.findElement(By.xpath("//input[@name='originAirport' and @value='SEA']"));
		departFrom.click();
		
		Thread.sleep(3000);
		WebElement to = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']"));
		to.click();
		to.clear();
		to.sendKeys("AUS");
	
		WebElement Destination = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']"));
		Destination.click();
		
		Thread.sleep(3000);

		// select passanger from static dropdown

		WebElement Passengers = driver.findElement(By.xpath("//*[@id='flightSearchForm.adultOrSeniorPassengerCount']"));
		Select select = new Select(Passengers);

		// select 9 passanger
		select.selectByVisibleText("3");

		Thread.sleep(3000);

		WebElement departureDate = driver.findElement(By.xpath("//input[@name='departDate']"));
		WebElement arrivalDate = driver.findElement(By.xpath("//input[@name='returnDate']"));
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));

		// departure 06/20/2020
		String depDate = "07/20/2023";
		// arrival 07/31/2020
		String retDate = "08/23/2023";

		// Select calendar date with JSExecutor for Departure date
		JavaScriptExecutor.scrollPageDownWithJS(driver,departureDate);
		JavaScriptExecutor.selectCalendarDateWithJS(driver, depDate, departureDate);
		JavaScriptExecutor.selectCalendarDateWithJS(driver, retDate, arrivalDate);

		Thread.sleep(3000);
		JavaScriptExecutor.getTitle(driver);
		searchButton.click();
		//JavaScriptExecutor.clickElementWithJS(searchButton, driver);

	}

}
