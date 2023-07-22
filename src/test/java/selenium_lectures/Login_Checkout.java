package selenium_lectures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptExecutor;

public class Login_Checkout {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		
		//WebDriver driver = new ChromeDriver();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://testenvironment.toptechschool.us/");
		
		driver.manage().window().maximize();
		
		System.out.print(driver.getTitle());
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		MyAccount.click();
		System.out.print(driver.getTitle());
		
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
	//	login.click();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	       
	        // Call the JavascriptExecutor methods
	        js.executeScript("arguments[0].click();", login);
		
		WebElement email =driver.findElement(By.xpath("//input[@id=\"input-email\"]"));
		//email.sendKeys("sadatsayedibrahim@gmail.com");
		JavaScriptExecutor.sendKeysWithJS(driver, email, "sadatsayedibrahim@gmail.com");
		//WebElement email = driver.findElement(By.cssSelector("input[name='email'"));
		
		
		WebElement password = driver.findElement(By.xpath("(//input[@class='form-control'])[2]  "));
		//password.sendKeys("test123");
		
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;

		JavaScriptExecutor.sendKeysWithJS(driver, password, "test123");
		
		
		WebElement loginBttn =driver.findElement(By.xpath("//input[@id='signinbtn']"));
		loginBttn.click();
		
		Thread.sleep(3000);
		
		/*

		WebElement items = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-inverse btn-block btn-lg ']"));

		items.click();
		
		WebElement checkout = driver.findElement(By.xpath("//a[text()='Checkout' and @class='btn btn-primary']"));
		checkout.click();
		
		Thread.sleep(3000);
		WebElement firstName = driver.findElement(By.xpath("//input[@name='first_name']"));
		firstName.sendKeys("Tom");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));
		lastName.sendKeys("Tom");
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.cssSelector("input[name='conutry']"));
		country.sendKeys("USA");
		
		WebElement street = driver.findElement(By.xpath("//input[@name='street_address']"));
		street.sendKeys("1st ave");
		
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("seattle");
		Thread.sleep(3000);
		WebElement state = driver.findElement(By.cssSelector("input[name='state']"));
		state.sendKeys("WA");
		
		WebElement zipCode =driver.findElement(By.xpath("//input[@name='zip_code']"));
		zipCode.sendKeys("98168");
		
		
		WebElement phone =driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("9999999999");
		Thread.sleep(3000);
		WebElement placeOrder =driver.findElement(By.xpath("//button[@id='btn']"));
		placeOrder.click();
		
		Thread.sleep(3000);
		
		*/
	}

}
