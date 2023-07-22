package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptExecutor;

public class DynamicDropDown2 extends JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();

		driver.get("https://www.aa.com/homePage.do");

		WebElement from = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));

		from.click();
		from.clear();
		Thread.sleep(3000);
		from.sendKeys("seat");

		
		WebElement  departure = driver.findElement(By.xpath("//ul[@id='ui-id-1']/child::li/a[@id='ui-id-11']"));

		departure.click();
		
	
		Thread.sleep(3000);

		WebElement to = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']"));
		to.sendKeys("miami");
		Thread.sleep(3000);

		WebElement destination = driver.findElement(By.xpath("//ul[@id='ui-id-2']/child::li/a[@id='ui-id-15']"));

		

		Thread.sleep(3000);
		WebElement Passengers = driver
				.findElement(By.xpath("//*[@id=\'flightSearchForm.adultOrSeniorPassengerCount\']"));

		Select select = new Select(Passengers);

		select.selectByValue("3");
		Thread.sleep(3000);
		WebElement departDate = driver.findElement(By.xpath("//input[@name='departDate']"));

		WebElement returnDate = driver.findElement(By.xpath("//input[@name='returnDate']"));

		WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));

		String deptDate = "07/20/2023";
		String retDate = " 09/11/2023";
		JavaScriptExecutor.selectCalendarDateWithJS(driver, deptDate, departDate);
		JavaScriptExecutor.selectCalendarDateWithJS(driver, retDate, returnDate);

		// departureDate.sendKeys(deptDate);
		// arrivalDate.sendKeys(retDate);

		// searchButton.click();
	}

}
