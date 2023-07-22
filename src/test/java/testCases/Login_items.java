package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_items {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://testenvironment.toptechschool.us/");

		driver.manage().window().maximize();

		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		MyAccount.click();

		WebElement Login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Login.click();

		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("sadatsayedibrahim@gmail.com");

		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("test123");

		WebElement loginBttn = driver.findElement(By.id("signinbtn"));
		loginBttn.click();

		String title = driver.getTitle();
		System.out.println(title);

		Thread.sleep(4000);

		WebElement items = driver
				.findElement(By.xpath("//button[@type='button' and @class='btn btn-inverse btn-block btn-lg ']"));

		items.click();

		String title2 = driver.getTitle();
		System.out.println(title2);
		Thread.sleep(2000);

		WebElement checkout = driver.findElement(By.xpath("//a[text()='Checkout' and @class='btn btn-primary']"));
		checkout.click();
		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.xpath("//input[@name='first_name']"));
		firstName.sendKeys("Tom");

		// lastName
		WebElement lastName = driver.findElement(By.cssSelector("input[name='last_name']"));
		lastName.sendKeys("Tommy");
		Thread.sleep(2000);
		WebElement country = driver.findElement(By.cssSelector("input[name='conutry']"));
		country.sendKeys("USA");

		WebElement streetAddrs = driver.findElement(By.cssSelector("input[name='street_address']"));
		streetAddrs.sendKeys("Seattle 1st ave");
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Seattle");
		Thread.sleep(2000);
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		state.sendKeys("WA");

		WebElement zipCode = driver.findElement(By.xpath("//input[@name='zip_code']"));
		zipCode.sendKeys("98168");

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("253999999");
		Thread.sleep(2000);
		WebElement placeOrder = driver.findElement(By.xpath("//button[@id='btn']"));
		placeOrder.submit();

		Thread.sleep(4000);

		driver.close();
	}
}
