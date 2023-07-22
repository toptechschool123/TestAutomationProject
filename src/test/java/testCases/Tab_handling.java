package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tab_handling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testenvironment.toptechschool.us/");

		driver.manage().window().fullscreen();

		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://toptechschool.us/courses.php");

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String paretnTab = it.next();

		driver.switchTo().window(paretnTab);

	}

}
