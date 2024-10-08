package basePackage;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	

	public static WebDriver driver;

	public static WebDriver browser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver",
				//		System.getProperty("user.dir") + ("\\driversss\\chromedriver.exe"));
 
				WebDriverManager.chromedriver().setup();

				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				//System.setProperty("webdriver.ie.driver",
				//		System.getProperty("user.dir") + ("\\Driver\\IEDriverServer.exe"));  
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				
				
			} else if (browserName.equalsIgnoreCase("firefox")) {
			//	System.setProperty("webdriver.gecko.driver",
			//			System.getProperty("user.dir") + ("\\Driver\\geckodriver.exe"));
				WebDriverManager.firefoxdriver().setup();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);

	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void backward() {
		driver.navigate().back();

	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void close() {
		driver.close();

	}

	
	public static void quite() {
		driver.quit();
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void enabled(WebElement element) {
		element.isEnabled();
	}

	public static void displayed(WebElement element) {
		element.isDisplayed();
	}

	public static void selected(WebElement element) {
		element.isSelected();
	}

	public static void screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinateFile = new File(System.getProperty("screenshot.dir")+"\\screenshot"+filename + ".png");
		FileUtils.copyFileToDirectory(sourceFile, destinateFile);

	} 
	
	public static void capture_screenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinateFile = new File(System.getProperty("screenshot.dir")+"\\screenshot"+filename + ".png");
		FileUtils.copyFileToDirectory(sourceFile, destinateFile);

	}
	
	

	public static void selection(WebElement element, String Option, String value) {
		Select sc = new Select(element);

		try {
			if (Option.equalsIgnoreCase("byIndex")) {
				int parseInt = Integer.parseInt(value);
				sc.selectByIndex(parseInt);
			} else if (Option.equalsIgnoreCase("byValue")) {
				sc.selectByValue(value);
			} else if (Option.equalsIgnoreCase("byVisibleText")) {
				sc.selectByVisibleText(value);
			} else {
				System.out.println("Invalid option");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void sendkeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void clearOnElement(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void simpleAlert() {
		driver.switchTo().alert().accept();

	}

	public static void confirmAlert(String ok, String cancel) {
		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();

		} else if (cancel.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();

		}
	}

	public static void promptAlert(String ok, String value, String cancel) {
		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();

		} else if (cancel.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();

		}
	}

	

	public static void pageUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public static void pageDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}
	
	public static void pageUpJs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000);");

	}

	public static void pageDownJs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);");
	}

	public static void frameMethod(String option, String value, WebElement element) {
		try {
			if (option.equalsIgnoreCase("byIndex")) {
				int index = Integer.parseInt(value);
				driver.switchTo().frame(index);
			} else if (option.equalsIgnoreCase("byElement")) {
				driver.switchTo().frame(element);

			} else if (option.equalsIgnoreCase("byString")) {
				driver.switchTo().frame(value);
			} else {
				System.out.println("Invalid selection");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void elementClear(WebElement element) {
		element.clear();
	}

	public static void windowHandles() {
		Set<String> element = driver.getWindowHandles();

		for (String st : element) {
			String title = driver.switchTo().window(st).getTitle();
			System.out.println(title);
		}
	}
}
