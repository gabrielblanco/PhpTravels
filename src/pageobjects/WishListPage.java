package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='#wishlist']") WebElement wishListButton;
	@FindBy(xpath="(//div[@id='wishlist']//div[@class='panel-body']//div)[1]") WebElement firstWish;
	
	/**
	 * Constructor method
	 * @param driverP
	 */
	public WishListPage(WebDriver driverP) {
		driver= driverP;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method redirects to the wish list view
	 */
	public void GoToWishList() {
		wishListButton.click();
	}
	/**
	 * This method returns the title of the first wish of list
	 * @return
	 */
	public String GetTitleOfFirstWish() {
			return firstWish.findElement(By.xpath("(//div[@class='panel-body']//b)[1]")).getText();
	
	}
}
