package selenium_lectures;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

		driver.manage().window().fullscreen();

		WebElement iframe = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		
		WebElement tryBttn = driver.findElement(By.xpath("//button[text()='Try it']"));
		tryBttn.click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert(); // switch to alert
		String textOfAlert = alert.getText();
		System.out.println(textOfAlert);
		alert.accept();
		
		Thread.sleep(2000);
	
	

		driver.close();

	}

}
