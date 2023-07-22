package selenium_lectures;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling  {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();

	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");

		driver.manage().window().fullscreen();
	
		// current window
		
		  String windowhandle = driver.getWindowHandle();
		  System.out.println(windowhandle);
		 
		WebElement mainBooking = driver.findElement(By.xpath("//*[@id=\"bookingsForm\"]/div[1]"));
		
		
		WebElement searchBus = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']"));
		//Thread.sleep(3000);
	
		searchBus.click();
		
		
		/*
		 * WebElement headerFrame = driver.findElement(By.xpath("//div[@id='TTDMsg']"));
		 * driver.switchTo().frame(headerFrame); driver.switchTo().frame(headerFrame);
		 * Thread.sleep(3000);
		 */
		  Alert alert = driver.switchTo().alert();
		  Thread.sleep(3000);
		  
		 String alertText= alert.getText();
		 System.out.println(alertText);
		 
		 
		 alert.accept();
		  
		 
		  
		  String pagettle = driver.getTitle();
		  System.out.println("This is before switching windows  " + pagettle);
		  
		  WebElement crm = driver.findElement(By.xpath("//p[text()='CRM']"));
		  crm.click(); // we to get window handles when we want to switch between
		  
		  Set<String> WindowsHandles = driver.getWindowHandles();
		  
		  // Iterator will iterate through the SET to get next index Iterator<String>
		  Iterator<String> it = WindowsHandles.iterator();
		  
		  String parentWindow = it.next();
		  String childwindow = it.next();
		  
		  driver.switchTo().window(childwindow); 
		 String  pagetitle = driver.getTitle();
		  System.out.println("This is After switching windows  " + pagetitle);
		  
			/* we use JS to avoid/resolve 'elementnotinteractibleException'
			 * WebElement ele = driver.findElement(By.xpath("element_xpath"));
			 * JavascriptExecutor executor = (JavascriptExecutor)driver;
			 * executor.executeScript("arguments[0].click();", ele);
			 */
		 
		  
		  
		  WebElement login  = driver.findElement(By.xpath("/html/body/header/div/nav/b[1]/a/b"));
		// login.click();
		  
		  JavascriptExecutor javascript = (JavascriptExecutor) driver;
		  javascript.executeScript("arguments[0].click();", login);
		  
			
		  WebElement userName = driver.findElement(By.id("user_session_email"));
		  userName.sendKeys("test@test.com");
		  
		  WebElement password = driver.findElement(By.id("user_session_password"));
		  password.sendKeys("wrongPassword");
		  
			
		  driver.switchTo().window(parentWindow);
		  System.out.println(driver.getTitle());
		  System.out.println("it is back to parent window ");
		  
		  
		 
		//  driver.close();
		

	}

}
