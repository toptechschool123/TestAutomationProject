package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

	// JavaScript Executor is an Interface that helps to execute JavaScript through
	// Selenium Webdriver.JavaScriptExecutor provides two methods " executescript" &
	// "executeAsyncript" to run
	// javascript on the selected window or current page.
	// static methods

	// ScrollPageDown using javaScript Executor.

	public static void scrollPageDownWithJS(WebDriver driver, WebElement element) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// js.executeAsyncScript("window.scrollTo(0,document.body.scrollHeight,10)");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public static void clickElementWithJS(WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeAsyncScript("arguments[0].click", element);

	}

	// sendKeys suing JSExecutor
	// WE can use sendKeys with JSExecutor , IF WebElement has either ID, Name or
	// class attributes-only one of them.

	public static void sendKeysWithJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + element + "').value='" + value + ";");

		
		
	}

	// abstraction 

	public static void selectCalendarDateWithJS(WebDriver driver, String date, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
		
	}
	
	public static void getTitle(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		String script = " return document.title;";
		String title = (String) js.executeScript(script);
		System.out.println(title);
	}

}
