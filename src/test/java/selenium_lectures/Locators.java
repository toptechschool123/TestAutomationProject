package selenium_lectures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		WebElement searchbox =driver.findElement(By.id("APjFqb"));
		searchbox.sendKeys("testing books");
		searchbox.clear();
		
		
		driver.close();
		
		// object oriented program (OOPS CONCEPTY) // Abstraction, encapsulation, inheritance, polymorphism
		// method overloading and method overriding 
		
	}
	
	public static void myData() {
		
	}
	
	public static void myData(int age) { 
		
	}

}
