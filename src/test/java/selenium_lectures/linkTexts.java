package selenium_lectures;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linkTexts {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.sugarcrm.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		System.out.println(driver.getTitle());
		
		

		WebElement forgotPassword = driver.findElement(By.partialLinkText("Forgot"));
		forgotPassword.click();


		Thread.sleep(4000);

		System.out.println(driver.getTitle());

	

		driver.close();
	}
}
