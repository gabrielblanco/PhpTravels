package pageobjects;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
	WebDriver driver;
	LinkedList<WebElement> hotelsList;
	@FindBy(xpath="//div[@id='body-section']//tbody//tr[3]//td[1]") WebElement firstHotel;
	
	/**
	 * Constructor method
	 * @param driverP
	 */
	public  HotelsPage(WebDriver driverP) {
		 driver= driverP;
		 PageFactory.initElements(driver, this);
		 hotelsList= new LinkedList<>();
		 hotelsList.add(firstHotel);
		 }
	/**
	 * This method returns the title of the first hotel of the  list
	 * @return
	 */
	public String GetTitleOfFirstHotel() {
		String name= hotelsList.get(0).findElement(By.xpath("//h4[contains(@class, 'RTL go-text-right mt0 mb4 list_title')]")).getText();
		return name;
	}
	/**
	 * This method clicks on the add to wish list button 
	 */
	public void addHotelToWishList() {
	   hotelsList.get(0).findElement(By.xpath("//div[contains(@data-placement, 'left')]")).click();
	}
}
