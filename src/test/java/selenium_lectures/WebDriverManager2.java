package selenium_lectures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		 ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");

		// getTitle();

		// driver.getTitle();
		 
		String title = driver.getTitle();
		System.out.println(title);
		
		
		
		System.out.println(driver.getTitle());

		// getCurrentUrl()
		System.out.println(driver.getCurrentUrl());
		
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().window().fullscreen();
		//driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().fullscreen();
		
		
		//driver.close();
		//driver.quit();

	}

}
