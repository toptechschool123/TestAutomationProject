package selenium_lectures;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.sugarcrm.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		

		
		  // List<WebElement>allLinks = driver.findElements(By.tagName("option")); //
		  List<WebElement>allLinks = driver.findElements(By.tagName("a"));
		//  List<WebElement> allLinks = driver.findElements(By.tagName("script"));
		  System.out.println(allLinks.size());
		  
		  for (int i = 0; i < allLinks.size(); i++){ //
		  System.out.println(allLinks.get(i).getAttribute("href"));
		 // System.out.println(allLinks.get(i).getAttribute("type"));
		  
		  // System.out.println(allLinks.get(i).getText());
		  
		  }
		 
		driver.close();
	}
}
