package utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	public static WebDriver driver;

	public static void implicitWait() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void elementTobClickable(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	
	public static void alertIsPresent() {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	wait.until(ExpectedConditions.alertIsPresent());
	
	
	}
	
	public static void fluentWait(WebElement element) {
		
		Wait<WebDriver> fluent_wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		
		           fluent_wait.until(ExpectedConditions.elementToBeClickable(element));
			

}
}