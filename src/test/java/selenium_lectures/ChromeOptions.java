package selenium_lectures;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptions {

	public static void main(String[] args) {
		
		// After some research , it looks it does not work well with maven project but with 
		//  system.setproperty.....
		
		WebDriverManager.chromedriver().setup();
		
		
		
		ChromeOptions option = new ChromeOptions();

	//	option.AddArgument("--headless");
	//	option.AddArgument("start-maximized"); 
	
    WebDriver   driver = new ChromeDriver();
		
		
		
		
		

		String url = "https://testenvironment.toptechschool.us/";
		
		driver.get(url);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
	
	}

}
