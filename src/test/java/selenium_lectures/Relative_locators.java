package selenium_lectures;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_locators {

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
		
	
		WebElement password =driver.findElement(RelativeLocator.with(By.tagName("input")).below(email));
		
		password.sendKeys("test123");
		
		WebElement loginBttn =driver.findElement(RelativeLocator.with(By.tagName("input")).below(password));
		loginBttn.click();
		

		/*
		String title = driver.getTitle();
		System.out.println(title);

	

		Thread.sleep(4000);
		WebElement logout = driver.findElement(By.xpath("(//a[@class='list-group-item'])[2]"));
		Thread.sleep(4000);
		logout.click();

		String title2 = driver.getTitle();
		System.out.println(title2);

		//driver.close();
		 * */
		 
	}

}
