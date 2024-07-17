package pageobject.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {

	public static WebDriver driver;

	@FindBy(xpath = "(//div[@class='rb_main_secondary_item  link'])[2]")
	private WebElement UserAccount;

	@FindBy(xpath = "//li[@id='user_sign_in_sign_up']")
	private WebElement login;

	@FindBy(xpath = "//iframe[@class='modalIframe']")
	private WebElement frameBox;

	public WebElement getFrameBox() {
		return frameBox;
	}

	@FindBy(xpath = "//input[@id='mobileNoInp']")
	private WebElement mobileNumber;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	private WebElement captchaCheckBox;

	@FindBy(xpath = "//div[@id='otp-container']")
	private WebElement generateOtpCTA;

	@FindBy(xpath = "//button[@id='verifyUser']")
	private WebElement verifyCTA;

	@FindBy(xpath = "(//div[@class='sc-ifAKCX kPhbmx'])[1]")
	private WebElement fromBox;

	@FindBy(xpath = "(//div[@class='sc-ifAKCX kPhbmx'])[2]")
	private WebElement toBox;

	@FindBy(xpath = "//div[@id='onwardCal']")
	private WebElement dateSelection;

	@FindBy(xpath = "(//label[@for='bt_SLEEPER'])[1]")
	private WebElement sleeperCheckBox;

	@FindBy(xpath = "//span[@class='f-bold busFound']")
	private WebElement numberOfBuses;
	
	@FindBy(xpath = "//div[@class='w-15 fl f-12 d-color']/child::span[text()='Fare']")
	private WebElement fareRange;

	public WebElement getNumberOfBuses() {
		return numberOfBuses;
	}

	public WebElement getBusFare() {
		return busFare;
	}

	public WebElement getAmenities() {
		return amenities;
	}

	@FindBy(xpath = "(//span[@class='f-19 f-bold'])[1]")
	private WebElement busFare;

	public WebElement getFareRange() {
		return fareRange;
	}

	

	public WebElement getSleeperCheckBox() {
		return sleeperCheckBox;
	}

	

	@FindBy(xpath = "//ul[@class='amenity-list clearfix']/li")
	private WebElement amenities;

	@FindBy(xpath = "//span[text()='17']")
	private WebElement selectDate;

	@FindBy(xpath = "//button[@id='search_button']")
	private WebElement searchBTN;

	@FindBy(xpath = "//li[@id='help_redcare']")
	private WebElement healpCare;

	@FindBy(xpath = "//span[text()='Technical Issues']/ancestor::div[@class='listitems']")
	private WebElement technicallIssuesBTN;

	@FindBy(xpath = "//div[@class='chip']")
	private WebElement responsesSuggestion;

	public PageObjectClass(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserAccount() {
		return UserAccount;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getCaptchaCheckBox() {
		return captchaCheckBox;
	}

	public WebElement getGenerateOtpCTA() {
		return generateOtpCTA;
	}

	public WebElement getVerifyCTA() {
		return verifyCTA;
	}

	public WebElement getFromBox() {
		return fromBox;
	}

	public WebElement getToBox() {
		return toBox;
	}

	public WebElement getDateSelection() {
		return dateSelection;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public WebElement getHealpCare() {
		return healpCare;
	}

	public WebElement getTechnicallIssuesBTN() {
		return technicallIssuesBTN;
	}

	public WebElement getResponsesSuggestion() {
		return responsesSuggestion;
	}

}
