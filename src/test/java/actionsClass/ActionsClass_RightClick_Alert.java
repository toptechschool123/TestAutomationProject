package actionsClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import selenium_lectures.ScreenShots;

public class ActionsClass_RightClick_Alert {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		// WebDriver driver = new ChromeDriver();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		driver.manage().window().maximize();

		System.out.print(driver.getTitle());
		ScreenShots.takeScreenShot(driver);
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement copyBttn = driver.findElement(By.xpath("//span[text()='Copy']"));
		Actions act = new Actions(driver);
		act.moveToElement(rightClick).contextClick().build().perform();
		Thread.sleep(3000);
		act.moveToElement(copyBttn).click().build().perform();

		Thread.sleep(3000);

		

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();
		System.out.println(alertText);

		alert.accept();
		// alert.dismiss();
		// alert.sendKeys("hi");
		

	}

}
