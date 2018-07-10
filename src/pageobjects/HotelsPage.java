package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {

	/**
	 * Web driver.
	 */
	WebDriver driver;

	/**
	 * Web element selectors.
	 */
	@FindBy(xpath="//div[@id='40']//a[@class='tooltip_flip tooltip-effect-1']") WebElement addToWishList;
	@FindBy(name = "checkin") WebElement checkIn;
	@FindBy(name = "checkout") WebElement checkOut;
	@FindBy(xpath = "//form[@name='fCustomHotelSearch']//button[@type='submit']") WebElement hotelSearchBtn;
	@FindBy(className = "itemscontainer") WebElement itemsContainer;
	
	/**
	 * Constructor method.
	 * @param driver is the web driver.
	 */
	public  HotelsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addHotelToWishList() {
		addToWishList.click();
	}

	/**
	 * Sets the check in date.
	 * @param inDate is the check in date.
	 */
	public void setCheckInDate(String inDate){
//		clickOnCheckIn();
//		List<WebElement> monthDays = driver.findElements(By.xpath("//div[contains(@class,'datepicker')][1]/div[@class='datepicker-days']//td"));
//		for (WebElement day : monthDays){
//			if (day.getText().contains(selectedDay + "")){
//				day.click();
//			}
//		}
		checkIn.sendKeys(inDate);
	}

	/**
	 * Sets the check out date.
	 * @param outDate is the check out date.
	 */
	public void setCheckOutDate(String outDate){
		checkOut.sendKeys(outDate);
	}

	/**
	 * Clicks on search hotel button.
	 */
	public void clickOnSearchBtn(){ hotelSearchBtn.click(); }

	public boolean noHotelsFound() {
		WebElement message = itemsContainer.findElement(By.tagName("h2"));
		return message.isEnabled();
	}

	/**
	 * Clicks on check in input text.
	 */
	private void clickOnCheckIn(){
		checkIn.click();
	}

	/**
	 * Clicks on check out input text.
	 */
	private void clickOnCheckOut(){
		checkOut.click();
	}

}
