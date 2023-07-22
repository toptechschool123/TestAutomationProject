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

public class DynamicDropDown extends JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();

		driver.get("https://www.aa.com/homePage.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		

		WebElement from = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
		
		from.click();
		from.clear();
		Thread.sleep(3000);
		from.sendKeys("seat");   
	
		
		
		
		List<WebElement> departure = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));

		for (WebElement city : departure) {

			
				if (city.getText().contains("SEA"))
					JavaScriptExecutor.clickElementWithJS(city, driver);
				
				
			}
		Thread.sleep(3000);
		
		WebElement to = driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']"));
		to.sendKeys("Aus");
		Thread.sleep(3000);
		
	List <WebElement> arrivalCity=	driver.findElements(By.xpath("//ul[@id='ui-id-2']/li/a"));
	
	for (WebElement arrCity: arrivalCity) { 
		
	
	try {
		if (arrCity.getText().trim().contains("AUS"))
			JavaScriptExecutor.clickElementWithJS(arrCity, driver);
	} catch (StaleElementReferenceException e) {
		e.printStackTrace();
	}

	WebElement Passengers = driver.findElement(By.xpath("//*[@id='flightSearchForm.adultOrSeniorPassengerCount']"));
	Thread.sleep(3000);
	Select select = new Select(Passengers);

	// select 9 passanger
	select.selectByVisibleText("3");

	WebElement departureDate = driver.findElement(By.xpath("//input[@name='departDate']"));
	Thread.sleep(3000);
	WebElement arrivalDate = driver.findElement(By.xpath("//input[@name='returnDate']"));
	Thread.sleep(3000);
	WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
	
	String deptDate = "07/20/2023";
	String retDate = " 09/11/2023";
	 
	JavaScriptExecutor.selectCalendarDateWithJS(driver, deptDate, departureDate);
	Thread.sleep(3000);
	JavaScriptExecutor.selectCalendarDateWithJS(driver, retDate, arrivalDate);
	//departureDate.sendKeys(deptDate);
    //	arrivalDate.sendKeys(retDate);
	
	//searchButton.click();
		}

	}
	}
	

