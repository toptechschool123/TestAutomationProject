package selenium_lectures;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		// WebDriver driver = new ChromeDriver();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com");

		driver.manage().window().maximize();


		WebElement drag = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a"));
		WebElement drop = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));

		Actions actions = new Actions(driver);
	
		drop.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		actions.dragAndDrop(source, target).build().perform();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		
		Thread.sleep(2000);
		
		WebElement resize = driver.findElement(By.xpath("//a[text()='Resizable']"));

		resize.click();
		Thread.sleep(2000);
		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(iframe2);
		Thread.sleep(2000);
		WebElement resizeBttn = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		
		//Actions action3 = new Actions(driver);
		Thread.sleep(2000);
		actions.dragAndDropBy(resizeBttn, 100, 100).build().perform();

		driver.close();
		

	}

}
