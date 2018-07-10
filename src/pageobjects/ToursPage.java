package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToursPage {
	WebDriver driver;
	@FindBy(xpath="(//table[@class='bgwhite table table-striped']//tr)[1]") WebElement firstTour;
	@FindBy(xpath="//div[@id='40']//a[@class='tooltip_flip tooltip-effect-1']") WebElement addToWishList;
	/**
	 * Constructor method
	 */
	public ToursPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void addTourToWishList() {
		firstTour.findElement(By.xpath("//td//div//span//div[contains(@data-placement,'left')]")).click();
	}
}
