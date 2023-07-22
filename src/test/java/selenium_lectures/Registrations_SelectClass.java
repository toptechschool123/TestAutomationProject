package selenium_lectures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DriverUtility;

public class Registrations_SelectClass {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://testenvironment.toptechschool.us/");
		
		driver.manage().window().maximize();
		
		System.out.print(driver.getTitle());
		
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
		MyAccount.click();
		
		System.out.print(driver.getTitle());
		
		Thread.sleep(3000);
		WebElement register =driver.findElement(By.xpath("(//a[text()='Register'])[1]"));
		register.click();
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Aziz");
		Thread.sleep(3000);
		WebElement lasttName = driver.findElement(By.id("input-lastname"));
		lasttName.sendKeys("Azizi");
		
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("aziz@toptechschool.us");
		Thread.sleep(3000);
		WebElement telephone = driver.findElement(By.id("input-telephone"));
		telephone.sendKeys("3333333333");
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		
		
		
		country.click();
		
	
		
		
		Select s = new Select(country);
		Thread.sleep(3000);
		s.selectByValue("Afghanistan");
		
		
		
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.id("input-password"));
		
	
		password.sendKeys("room123");
		

		WebElement confirm_password = driver.findElement(By.id("input-confirm"));
		confirm_password.sendKeys("room123");
		
		Thread.sleep(3000);
				
		WebElement newletter = driver.findElement(By.xpath("(//input[@name='newsletter'])[1]"));
		System.out.println(newletter.isSelected());	
		newletter.click();	
		
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='agree']"));
		System.out.println(checkbox.isEnabled());
		checkbox.click();
		Thread.sleep(3000);
		WebElement continueBttn = driver.findElement(By.xpath("//input[@id='signupbtn']"));
		continueBttn.click();
		
		Thread.sleep(3000);
		
	}

}
