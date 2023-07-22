package selenium_lectures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptExecutor;

public class DynamicDropDowns extends JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		
	
		driver.manage().window().maximize();
		
		
		
		
		
		
		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();

		System.out.print(driver.getTitle());

		WebElement fromBttn = driver.findElement(By.xpath("//span[text()='From']"));
		fromBttn.click();
		Thread.sleep(2000);

		WebElement from_City = driver.findElement(By.xpath("//p[text()='New Delhi, India']"));
		from_City.click();
		Thread.sleep(2000);
		WebElement toCity = driver.findElement(By.id("toCity"));
		toCity.click();
		Thread.sleep(2000);
		WebElement destination_city = driver.findElement(By.xpath("(//p[@class='font14 appendBottom5 blackText'])[3]"));
		destination_city.click();
		Thread.sleep(2000);

		
		WebElement departure = driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[1]"));
		departure.click();
		String departureDate = "10 Jul'23";
		Thread.sleep(2000);
		JavaScriptExecutor.selectCalendarDateWithJS(driver, departureDate, departure);
	
		 driver.close();
	}

}
