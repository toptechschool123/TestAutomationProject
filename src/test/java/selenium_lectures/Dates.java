package selenium_lectures;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptExecutor;

public class Dates extends JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	

		driver.get("https://www.aa.com/homePage.do");
	

		WebElement from = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));

	
		from.click();
	
		from.clear();

		Thread.sleep(3000);
		from.sendKeys("seat");

		
		List<WebElement> departure = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));

		for (WebElement city : departure) {

			if (city.getText().trim().contains("SEA"))
				JavaScriptExecutor.clickElementWithJS(city, driver);

		}
		
		
		Thread.sleep(3000);
		WebElement to = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']"));
		to.click();
		to.clear();
		to.sendKeys("AUS");

		List<WebElement> arrival = driver.findElements(By.xpath("//ul[@id='ui-id-2']/li"));

		for (WebElement cityArrival : arrival) {

			try {
				if (cityArrival.getText().trim().contains("AUS"))
					JavaScriptExecutor.clickElementWithJS(cityArrival, driver);
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}

		}

		Thread.sleep(3000);

		// select passanger from static dropdown

		WebElement passegers = driver.findElement(By.xpath("//*[@id='flightSearchForm.adultOrSeniorPassengerCount']"));
		Select select = new Select(passegers);

		// select 9 passanger
		select.selectByVisibleText("3");

		Thread.sleep(3000);

		WebElement departureDate = driver.findElement(By.xpath("//input[@name='departDate']"));
		WebElement arrivalDate = driver.findElement(By.xpath("//input[@name='returnDate']"));
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));

		
		String depDate = "07/20/2023";
	
		String retDate = "08/23/2023";

	
		JavaScriptExecutor.selectCalendarDateWithJS(driver, depDate, departureDate);
		JavaScriptExecutor.selectCalendarDateWithJS(driver, retDate, arrivalDate);

		Thread.sleep(3000);

		searchButton.click();

	}

}
