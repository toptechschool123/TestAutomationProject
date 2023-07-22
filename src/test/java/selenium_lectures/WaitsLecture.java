package selenium_lectures;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsLecture {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		//WebDriver driver = new ChromeDriver();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testenvironment.toptechschool.us/");
		
		driver.manage().window().maximize();
		
		System.out.print(driver.getTitle());
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		MyAccount.click();
		System.out.print(driver.getTitle());
		
		
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		login.click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(MyAccount));
		wait.until(ExpectedConditions.alertIsPresent());
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("xpath")));
		wait.until(ExpectedConditions.visibilityOf(login));
		wait.until(ExpectedConditions.elementToBeSelected(login));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		
		
		
	}
	
	public static void fluentWait(WebDriver driver) {
		Wait<WebDriver> fluent_wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		
		
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		
		
		fluent_wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();		
	}

}
