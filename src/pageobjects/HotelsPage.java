package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
	WebDriver driver;
	@FindBy(xpath="//div[@id='40']//a[@class='tooltip_flip tooltip-effect-1']") WebElement addToWishList;
	
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
	
	
}
