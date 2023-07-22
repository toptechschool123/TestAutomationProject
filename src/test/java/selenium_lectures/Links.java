package selenium_lectures;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {

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
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(int i = 0; i<links.size(); i++) {
			System.out.println(links.get(i).getAttribute("href"));
			
		}
	
	
		
		driver.quit();
	}
}
