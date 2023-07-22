package selenium_lectures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptExecutor;

public class Login_Checkout2 {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		
		//WebDriver driver = new ChromeDriver();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://testenvironment.toptechschool.us/");
		
		driver.manage().window().maximize();
		
		System.out.print(driver.getTitle());
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
	//	MyAccount.click();
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	       
	  
	        js.executeScript("arguments[0].click();", MyAccount);
	        
	
		
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		//login.click();
		
	        js.executeScript("arguments[0].click();", login);
		
		WebElement email =driver.findElement(By.id("input-email"));
		//email.sendKeys("sadatsayedibrahim@gmail.com");
		JavaScriptExecutor.sendKeysWithJS(driver, email, "sadatsayedibrahim@gmail.com");
	
	
		//  js.executeScript("document.getElementById('s').value='Avinash Mishra';");
		
		
		
		
		//
		//WebElement email = driver.findElement(By.cssSelector("input[name='email'"));
		
		
		WebElement password = driver.findElement(By.xpath("(//input[@class='form-control'])[2]  "));
		//password.sendKeys("test123");
		
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;

		JavaScriptExecutor.sendKeysWithJS(driver, password, "test123");
		
		
		WebElement loginBttn =driver.findElement(By.xpath("//input[@id='signinbtn']"));
		loginBttn.click();
		
		Thread.sleep(3000);
		
	
	}

}
