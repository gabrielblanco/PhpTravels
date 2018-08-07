package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='#wishlist']") WebElement wishListButton;
	@FindBy(xpath="(//div[@id='wishlist']//div[@class='panel-body']//div)[1]") WebElement firstWish;
	@FindBy(xpath = "//div[@id='wishlist']/div/div[1]//a[contains(text(),'Preview')]") WebElement firstPreviewButton;
	
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new WebDriverWait(driver, 30 ).until(ExpectedConditions.elementToBeClickable(wishListButton));
		wishListButton.click();
	}
	/**
	 * This method returns the title of the first wish of list
	 * @return
	 */
	public String GetTitleOfFirstWish() {
		return firstWish.findElement(By.xpath("(//div[@class='panel-body']//b)[1]")).getText();
	}

	/**
	 * Goes to the first wish-list hotel preview page.
	 */
	public void goToPreview() {
		new WebDriverWait(driver, 10 ).until(ExpectedConditions.visibilityOf(firstPreviewButton));
		firstPreviewButton.click();
	}
}
