package selenium_lectures;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Waits;

public class utilApplication {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://testenvironment.toptechschool.us/");
		
		// implicit wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();

		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		
		
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(MyAccount));
		MyAccount.click();
		
		

		WebElement Login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Login.click();

		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("sadatsayedibrahim@gmail.com");

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("test123");

		WebElement loginBttn = driver.findElement(By.id("signinbtn"));
		loginBttn.click();

	
		Thread.sleep(4000);
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]"));
		
//Thread.sleep(4000);


		//fluent wait
		Wait<WebDriver> fluent_wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		fluent_wait.until(ExpectedConditions.elementToBeClickable(logout));
		
		logout.click();

	
		

		//driver.close();

	}

}
