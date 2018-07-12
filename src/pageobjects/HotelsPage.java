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
	//LinkedList<WebElement> hotelsList;
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
