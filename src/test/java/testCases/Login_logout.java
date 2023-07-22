package testCases;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_logout {

	public static void main(String[] args) throws InterruptedException {

WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testenvironment.toptechschool.us/");
		
		driver.manage().window().maximize();
		
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		MyAccount.click();
		
		WebElement Login =driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Login.click();
		
		
		WebElement email =driver.findElement(By.id("input-email"));
		email.sendKeys("sadatsayedibrahim@gmail.com");
		
		WebElement password =driver.findElement(By.id("input-password"));
		password.sendKeys("test123");
		
		WebElement loginBttn = driver.findElement(By.id("signinbtn"));
		loginBttn.click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Thread.sleep(4000);
		WebElement logout = driver.findElement(By.xpath("(//a[@class='list-group-item'])[2]"));
		Thread.sleep(4000);
		
		
		
		Wait<WebDriver> fluent_wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .withMessage("hi")
				  .ignoring(NoSuchElementException.class);
		
		           fluent_wait.until(ExpectedConditions.elementToBeClickable(logout));
		           logout.click();
		           
		String title2 =driver.getTitle();
		System.out.println(title2);
		
	//	driver.close();
		
	}
}
