package test.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import basePackage.Base;
import pageobject.com.PageObjectClass;

public class RedBus extends Base {

	public PageObjectClass p;
	public static Robot r;

	@BeforeSuite
	private void browser() {
		browser("chrome");
		getUrl("https://www.redbus.in/");
        System.out.println("Vanakam da mapla");
	}

	@Test(priority = 1)
	private void userAccount() {

		p = new PageObjectClass(driver);

		clickOnElement(p.getUserAccount());

	}

	@Test(priority = 2)
	private void loginIn() {

		clickOnElement(p.getLogin());

	}

	@Test(priority = 3)
	private void mobileNumber() throws InterruptedException {
		Thread.sleep(5000);
//		sendkeys(p.getMobileNumber(), "9786760239");

		driver.switchTo().frame(p.getFrameBox());
		p.getMobileNumber().sendKeys("9786760239");

	}

	@Test(priority = 4)
	private void captchaCheckBox() {

		clickOnElement(p.getCaptchaCheckBox());

	}

	@Test(priority = 5)
	private void generateCTA() throws InterruptedException {
		Thread.sleep(10000);
		clickOnElement(p.getGenerateOtpCTA());

	}

	@Test(priority = 6)
	private void verifyCTA() throws InterruptedException {

		Thread.sleep(10000);
		clickOnElement(p.getVerifyCTA());

	}

	@Test(priority = 7)
	private void fromTravel() throws InterruptedException,AWTException {
		p = new PageObjectClass(driver);

		Thread.sleep(3000);
		sendkeys(p.getFromBox(), "Bang");
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
	
	@Test(priority = 7)
	private void toTravel() throws InterruptedException,AWTException {
		p = new PageObjectClass(driver);

		Thread.sleep(3000);
		sendkeys(p.getFromBox(), "che");
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test(priority = 8)
	private void calender()  {
		clickOnElement(p.getDateSelection());

	}
	
	@Test(priority = 9)
	private void dateSelection()  {

		clickOnElement(p.getSelectDate());
	}
	
	@Test(priority = 10)
	private void searchBus()  {

		clickOnElement(p.getSearchBTN());
	}
	
	@Test(priority = 11)
	private void sleeperCheckBox()  {
      
		clickOnElement(p.getSleeperCheckBox());

	}
	
	@Test(priority = 12)
	private void busesFoundBasedOnSearch() {
		String text = p.getNumberOfBuses().getText();
		System.out.print("Number Of Buses Found :"+text);

	}
	
	@Test(priority = 13)
	private void cheapestRate() throws InterruptedException {
		
		clickOnElement(p.getFareRange());
		Thread.sleep(3000);
		String lowestFare = p.getFareRange().getText();
		System.out.println("Lowest Bus Fare"+lowestFare);

	}
	
	@Test(priority = 14)
	private void highestRate() throws InterruptedException {
		
		clickOnElement(p.getFareRange());
		Thread.sleep(3000);

		String highestRate = p.getFareRange().getText();
		System.out.println("Lowest Bus Fare"+highestRate);

	}
	
	@Test(priority = 15)
	private void  numberOfAmenities() throws InterruptedException {
		
		
		Thread.sleep(3000);

		String numberOfAmenities = p.getAmenities().getText();
		System.out.println("Lowest Bus Fare"+numberOfAmenities);

	}
	
	
	
	
	
	
	
	
	
}
