package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");

		driver.manage().window().fullscreen();

		WebElement searchButton = driver.findElement(
				By.xpath("//button[@type='button' and @class='btn btn-primary btn-lg btn-block btn-booking']"));
		searchButton.click();

		Alert a = driver.switchTo().alert();
		String alertText = a.getText();
		System.out.println(alertText);

		a.accept();
		Thread.sleep(3000);
		WebElement CRM_Bttn = driver
				.findElement(By.xpath("/html/body/header/div/div/div[2]/div[2]/div/ul/li[3]/a/img"));
		CRM_Bttn.click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
		
		//WebElement loginBttn = driver.findElement(By.xpath("/html/body/header/div/nav/b[1]/a/b"));
		 WebElement login  = driver.findElement(By.xpath("/html/body/header/div/nav/b[1]/a/b"));
		 login.click();
		
		 
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("user_session_email"));
		email.sendKeys("sayed@gmail.com");
		WebElement password = driver.findElement(By.id("user_session_password"));
		password.sendKeys("123");
		Thread.sleep(3000);
		WebElement checkBox = driver.findElement(By.id("user_session_remember_me"));
		if (!checkBox.isSelected()) {
			System.out.println("check box is  selected already ");

		} else
			checkBox.click();
		System.out.println("check box is not selected");
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow);
		
	}

}
