package selenium_lectures;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		String title = driver.getTitle();

		System.out.println(title);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		driver.manage().window().maximize();
		
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();
		driver.navigate().to("https://toptechschool.us/");

		String title2 = driver.getTitle();
		System.out.println(title2);
		String url2 = driver.getCurrentUrl();
		System.out.println(url2);
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.close();
		driver.quit();

	}

}
