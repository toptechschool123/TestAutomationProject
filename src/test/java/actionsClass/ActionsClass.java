package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

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
		login.click();
		
		
		WebElement email =driver.findElement(By.xpath("//input[@id=\"input-email\"]"));
		email.sendKeys("sadatsayedibrahim@gmail.com");
		
		//WebElement email = driver.findElement(By.cssSelector("input[name='email'"));
		
		
		WebElement password = driver.findElement(By.xpath("(//input[@class='form-control'])[2]  "));
		password.sendKeys("test123");
		
		WebElement loginBttn =driver.findElement(By.xpath("//input[@id='signinbtn']"));
		loginBttn.click();
		
		Thread.sleep(3000);
		
		
		WebElement cameras =driver.findElement(By.xpath("//a[text()='Cameras']"));
		
		
		WebElement Sony =driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[4]/a"));
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(cameras).build().perform();
		Thread.sleep(3000);
		act.moveToElement(Sony).click().build().perform();
		Thread.sleep(3000);
		
		WebElement addToCart =driver.findElement(By.xpath("//button[@type='button' and @onclick='addtocart(2966628,1)']"));
		//act.moveToElement(addToCart).click().build().perform();
		addToCart.click();
		Thread.sleep(3000);
		WebElement logout1=driver.findElement(By.xpath("(//a[text()='My Account'])[2]"));
		act.moveToElement(logout1).click().build().perform();
		Thread.sleep(3000);
		WebElement logout2 =driver.findElement(By.xpath("//a[text()='logout']"));
		logout2.click();
	}

}
