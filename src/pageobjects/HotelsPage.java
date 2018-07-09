package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
	WebDriver driver;
	@FindBy(xpath="//div[@id='40']//a[@class='tooltip_flip tooltip-effect-1']") WebElement addToWishList;
	@FindBy(name = "checkin") WebElement checkIn;
	@FindBy(name = "checkout") WebElement checkOut;
	
	/**
	 * Constructor method
	 * @param driverP
	 */
	public  HotelsPage(WebDriver driverP) {
		driver= driverP;
		PageFactory.initElements(driver, this);
	}
	
	public void addHotelToWishList() {
		addToWishList.click();
	}

	public void selectCheckInDate(){
		clickOnCheckIn();
		WebElement checkInDate = driver.findElement(By.xpath("//div[@class='datepicker-days']//td[@class='day '][contains(text(),'14')]"));
		checkInDate.click();
	}

	public void selectCheckOutDate(){
//		clickOnCheckOut();
		WebElement datepicker = driver.findElement(By.xpath("//div[@class='datepicker-days']"));
		if (datepicker.isDisplayed()){
			System.out.println("Element already displayed.");
			WebElement checkOutDate = driver.findElement(By.xpath("//div[@class='datepicker-days']//td[@class='day '][contains(text(),'16')]"));
			checkOutDate.click();
		} else {
			System.out.println("Element not displayed jet.");
		}

		if (datepicker.isEnabled()){
			System.out.println("Element Enable.");
			WebElement checkOutDate = driver.findElement(By.xpath("//div[@class='datepicker-days']//td[@class='day '][contains(text(),'16')]"));
			checkOutDate.click();
		} else {
			System.out.println("Element Disable.");
		}
	}

	private void clickOnCheckIn(){
		checkIn.click();
	}

	private void clickOnCheckOut(){
		checkOut.click();
	}

}
