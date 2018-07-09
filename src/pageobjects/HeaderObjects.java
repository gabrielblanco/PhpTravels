package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderObjects {
 WebDriver driver;
 @FindBy(xpath="//div[@class='navbar-header']//a[@href='https://www.phptravels.net/']//img[@src='https://www.phptravels.net/uploads/global/logo.png']") WebElement icon;
 @FindBy(xpath= "//a[@href='https://www.phptravels.net/'][contains(text(),'Home')]") WebElement home;
 @FindBy(xpath="//a[@class='loader'][contains(text(),'Hotels')]") WebElement hotels;
 @FindBy(xpath="//a[@class='loader'][contains(text(),'Flights')]") WebElement flights;
 @FindBy(xpath="//a[@class='loader'][contains(text(),'Tours')]") WebElement tours;
 @FindBy(xpath="//a[@class='loader'][contains(text(),'Cars')]") WebElement cars;
 @FindBy(xpath="//a[@class='loader'][contains(text(),'Visa')]") WebElement visa;
 @FindBy(xpath="//a[@class='loader'][contains(text(),'Offers')]") WebElement offers;
 @FindBy(xpath="//a[@class='loader'][contains(text(),'Blog')]") WebElement blog;
 @FindBy(xpath="//div[@class='container']//li[@id='li_myaccount']") WebElement MyAcountDropDown;

	/**
	 * Constructor method
	 * @param driver
	 */
	public HeaderObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method displays "My account" drop down 
	 */
	public void DisplayMyAccountDropDown() {
		MyAcountDropDown.click();
	}
	/**
	 * This method selects the login item from my account drop down
	 */
	public void SelectLoginItem() {
		WebElement loginItem= driver.findElement(By.xpath("//html//nav[@class='navbar navbar-default']//li[@id='li_myaccount']//li[1]/a[1]"));
		loginItem.click();
	}
	/**
	 * This method redirects to the login view
	 */
	public void GoToLogin() {
		DisplayMyAccountDropDown();
	}
	/**
	 * This method clicks on the header hotels button
	 */
	public void GoToHotels() {
		hotels.click();
	}
	/**
	 * This method clicks on the header home button
	 */
	public void GoToHome() {
		home.click();
	}
	/**
	 * This method clicks on the web site icon
	 */
	public void GoToHomeByIcon() {
		icon.click();
	}
	/**
	 * This method clicks on the header flights button
	 */
	public void GoToFlights() {
		flights.click();
	}
	/**
	 * This method clicks on the header tours button
	 */
	public void GoToTours() {
		tours.click();
	}
	/**
	 * This method clicks on the header cars button
	 */
	public void GoToCars() {
		cars.click();
	}
	/**
	 * This method clicks on the header visa button
	 */
	public void GoToVisa() {
		visa.click();
	}
	/**
	 * This method clicks on the header offers button
	 */
	public void GoToOffers() {
		offers.click();
	}
	/**
	 * This method clicks on the header blogs button
	 */
	public void GoToBlog() {
		blog.click();
	}
}
