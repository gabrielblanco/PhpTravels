package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarsPage {

    /**
     * Web driver
     */
    WebDriver driver;

    /**
     * Web element selectors.
     */
    @FindBy(xpath = "//a[@href='#collapseMap']") WebElement viewMapBtn;
    @FindBy(xpath = "//div[@id='collapseMap'][1]//div[@id='map']") WebElement mapContainer;
    @FindBy(id="searchform") WebElement searchFilterButton;
    /**
     * Constructor method.
     * @param driver is the web driver.
     */
    public CarsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks over view map button.
     */
    public void clicOnViewMapBtn(){
        viewMapBtn.click();
    }

    /**
     * Verifies is the container has a map inside.
     */
    public boolean containsMap(){
        try {
            WebElement map = mapContainer.findElement(By.xpath("//iframe"));
            System.out.println(map.getLocation());
            return true;
        } catch (Exception e) {
            System.out.println("The Map Container does not have any map inside.");
            return false;
        }
    }
    
    /**
	 * Filter a car by selecting star grade.
	 * @param propertyType is the property type
	 */
	public void findByStarGrade(String propertyType){
		WebElement property = driver.findElement(By.xpath("(//input[@id='"+propertyType+"'])[1]/parent::div/ins"));
		property.click();
		clickSearchFilterButton();
	}
	
	/**
	 * This method clicks on the search button 
	 */
	public void clickSearchFilterButton() {
		searchFilterButton.click();
	}
}
