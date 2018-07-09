package pageobjects;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='#wishlist']") WebElement wishListButton;
	LinkedList<WebElement> wishList;
	@FindBy(id="wish7") WebElement firstWish;
	
	/**
	 * Constructor method
	 * @param driverP
	 */
	public WishListPage(WebDriver driverP) {
		driver= driverP;
		PageFactory.initElements(driver, this);
		wishList= new LinkedList<>();
		wishList.add(firstWish);
	}
	/**
	 * This method redirects to the wish list view
	 */
	public void GoToWishList() {
		wishListButton.click();
	}
	/**
	 * This method returns the name of the first hotel of list
	 * @return
	 */
	public String GetNameOfHotel() {
		String name="";
		for(int i=0; i<wishList.size(); i++){
			if(i==0) {
				name= wishList.get(i).findElement(By.xpath("//div[contains(@class,'col-md-5 offset-0')]//a//b[contains(@xpath,'1')]")).getText();
				break;
			}
		 }
		return name;
	}
}
