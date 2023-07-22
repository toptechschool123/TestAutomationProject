package selenium_lectures;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {

WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testenvironment.toptechschool.us/");
		
		driver.manage().window().maximize();
		
	//	WebElement MyAccount = driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[2]"));
		WebElement MyAccount = driver.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']/following-sibling::span"));
		MyAccount.click();
		
		
		
	//	WebElement Login =driver.findElement(By.xpath("//body/div/nav/div/div/ul/li[2]/ul/li[2]/a"));
		WebElement Login =driver.findElement(By.xpath("//a[text()='Login']/ancestor::*/parent::li/child::ul/child::li[2]"));
		Login.click();                                   
		
		
		
	//	WebElement email =driver.findElement(By.xpath("//input[@id='input-email']"));
		
		
		WebElement email =driver.findElement(By.cssSelector("#input-email"));
		email.sendKeys("sadatsayedibrahim@gmail.com");
		
		
		
		//WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
		
		
		WebElement password =driver.findElement(By.cssSelector("input[name='password']"));
		password.sendKeys("test123");
		
		
		//WebElement loginBttn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		WebElement loginBttn = driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
		
		loginBttn.click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
			
		
		Thread.sleep(4000);
		WebElement logout = driver.findElement(By.xpath("//a[text()='logout']"));
		Thread.sleep(4000);
		logout.click();
		
		
		String title2 =driver.getTitle();
		System.out.println(title2);
		
	//	driver.close();
		
		
	}
}
