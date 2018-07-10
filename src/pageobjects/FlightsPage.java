package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
	WebDriver driver;
	@FindBy(xpath="(//table[@id='load_data']//tr)[1]") WebElement firstFlight;
	@FindBy(xpath="//div[@id='collapseExample0']//div[@class='panel-body']") WebElement flightDescripcion;
	/**
	 * Constructor method
	 * @param driver
	 */
	public FlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	/**
	 * This method clicks the details button of the first flight in the list
	 */
	public void ClickOnDetails() {
		firstFlight.findElement(By.xpath("//td/div[2]//a")).click();
	}
	
	public boolean descriptionIsDisplayed() {
		if(flightDescripcion.isDisplayed()) {
			System.out.println("Description displayed");
			return true;
		}else if (!flightDescripcion.isDisplayed()) {
			System.out.println("Description isnt displayed");
			return false;
		}else {
		System.out.println("Web element not found");
		return  false;
		} 
	}
}
