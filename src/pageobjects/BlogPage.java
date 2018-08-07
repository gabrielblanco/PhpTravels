package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
    WebDriver driver;
    @FindBy(name="s") 
    WebElement findInput;
    @FindBy(xpath="//div[@class='panel-body']") 
    WebElement findButton;
    
   /**
    * Constructor method
    * @param driver
    */
	public BlogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}

	/**
	 * This method types on the quick search input
	 * @param blogName
	 */
	public void typeBlogName(String blogName) {
		this.findInput.sendKeys(blogName);
	}
	
	/**
	 * This method clicks on the find  button
	 */
	public void ClickOnFind() {
		this.findButton.click();
	}
	
	/**
	 * This method searches the user blog
	 * @param blogName
	 */
	public void quickSearch(String blogName) {
		this.typeBlogName(blogName);
		this.ClickOnFind();
	}
	
}