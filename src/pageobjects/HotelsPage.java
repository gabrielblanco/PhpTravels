package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelsPage {

	/**
	 * Web driver.
	 */
	WebDriver driver;

	/**
	 * This is the offsetRange for price range slider.
	 */
	private final int offsetRange = 176;

	/**
	 * Web element selectors.
	 */
	@FindBy(xpath="//div[@id='40']//a[@class='tooltip_flip tooltip-effect-1']") WebElement addToWishList;
	@FindBy(name = "checkin") WebElement checkIn;
	@FindBy(name = "checkout") WebElement checkOut;
	@FindBy(xpath = "//div[@class='slider-handle round'][1]") WebElement minRange;
	@FindBy(xpath = "//div[@class='slider-handle round'][2]") WebElement maxRange;
	@FindBy(className = "tooltip-inner") WebElement tooltipValue;
	@FindBy(className = "slider-selection") WebElement sliderBar;
	@FindBy(xpath = "//form[@name='fCustomHotelSearch']//button[@type='submit']") WebElement hotelSearchBtn;
	@FindBy(className = "itemscontainer") WebElement itemsContainer;
	@FindBy(xpath="	(//table[@class='bgwhite table table-striped']//tr)[1]") WebElement firstHotel;
	@FindBy(id = "searchform") WebElement searchFilterButton;
	
	/**
	 * Constructor method.
	 * @param driverP is the web driver.
	 */
	public  HotelsPage(WebDriver driverP) {
		 driver= driverP;
		 PageFactory.initElements(driver, this);
	 }
  
	/**
	 * This method returns the title of the first hotel of the  list
	 * @return
	 */
	public String GetTitleOfFirstHotel() {
		return firstHotel.findElement(By.xpath("(//h4[contains(@class, 'RTL go-text-right mt0 mb4 list_title')])[1]")).getText();
	}
  
	/**
	 * This method clicks on the add to wish list button 
	 */
	public void addHotelToWishList() {
	  firstHotel.findElement(By.xpath("(//div[contains(@data-placement, 'left')])[1]")).click();
	}

	/**
	 * Filter hotels by the given price range.
	 * @param minPrice is the minimum price.
	 * @param maxPrice is the maximum price.
	 */
	public void findByPriceRange(int minPrice, int maxPrice){
		if (validatePriceRange(minPrice, maxPrice)) {
			setMinRange(minPrice);
			setMaxRange(maxPrice);
			searchFilterButton.click();
		} else {
			System.out.println("The price values must be between $50 and $500. [$50 - $500]");
		}
	}

	public boolean isPriceResult(int minPrice, int maxPrice){
		boolean match = false;
		List<WebElement> hotelsList = driver.findElements(By.xpath("//table[@class='bgwhite table table-striped']//tr//div[3]//b"));
		System.out.println("Price Range: " + minPrice + ", " + maxPrice);
		for (WebElement hotel : hotelsList) {
			String text = hotel.getText();
			String textResult = text.substring(1);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotel);
			match = (Integer.parseInt(textResult) >= minPrice) && ((Integer.parseInt(textResult) <= maxPrice));
			System.out.println("Dollars: " + hotel.getText() + " - Match: " + match);
		}
		return match;
	}

	/**
	 * Validates the prices must be between $50 and $500.
	 * @param minPrice is the minimum price.
	 * @param maxPrice is the maximum price.
	 * @return if the price is in the range.
	 */
	private boolean validatePriceRange(int minPrice, int maxPrice) {
		return (minPrice >= 50) && (maxPrice <= 500);
	}

	/**
	 * Filter a hotel by selecting a property type.
	 * @param propertyType is the property type
	 */
	public void findByProperty(String propertyType){
		WebElement property = driver.findElement(By.xpath("//div[@id='collapse3']//input[@id='" + propertyType + "']/parent::div/ins"));
		property.click();
		searchFilterButton.click();
	}

	/**
	 * Filter hotels by selecting multiple property types.
	 * @param properties are the property types.
	 */
	public void findByMultipleProperties(String[] properties){
		for (String property : properties){
			WebElement element = driver.findElement(By.xpath("//div[@id='collapse3']//input[@id='" + property + "']/parent::div/ins"));
			element.click();
		}
		searchFilterButton.click();
	}
  
	/**
	 * Sets the check in date.
	 * @param inDate is the check in date.
	 */
	public void setCheckInDate(String inDate){
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
	 * Search the minimum price by slider percentage.
	 * @param minPrice is the minimum price.
	 */
	private void setMinRange(int minPrice) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (double i=0; i<=100; i+=0.5) {
			new Actions(driver).moveToElement(tooltipValue).build().perform();
			String priceRange = tooltipValue.getText();
			String[] values = priceRange.split(" : ");
			String min = values[0];
			if (Integer.parseInt(min) != minPrice) {
				js.executeScript("arguments[0].setAttribute('style', 'left:"+ i + "%')", minRange);
				minRange.click();
			} else {
				break;
			}
		}
	}

	/**
	 * Search the maximum price by slider percentage.
	 * @param maxPrice is the maximum price.
	 */
	private void setMaxRange(int maxPrice) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (double i=100; i>=0; i-=0.5) {
			new Actions(driver).moveToElement(tooltipValue).build().perform();
			String priceRange = tooltipValue.getText();
			String[] values = priceRange.split(" : ");
			String max = values[1];
			if (Integer.parseInt(max) != maxPrice) {
				js.executeScript("arguments[0].setAttribute('style', 'left:"+ i + "%')", maxRange);
				maxRange.click();
			} else {
				break;
			}
		}
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
