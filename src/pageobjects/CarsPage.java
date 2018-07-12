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
    @FindBy(xpath="(//table[@class='bgwhite table table-striped']//td)[1]") WebElement firstCar;
    
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
     * This method verifies that the number of stars of the first element of the list is equal to the stars of the filter
     *      * @return
     */
    public boolean ValidateStarsFirstElement(int stars) {
    	if(stars==GetStarGradeFirstElement()) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    /**
     *This method returns the number of stars of the first element of the list 
     * @return
     */
    public int GetStarGradeFirstElement() {
    	int numberOfStars=0;
    	WebElement star= firstCar.findElement(By.xpath("(//span[contains(@class,'go-right mob-fs10')]//i)[1]"));
    	for (int i = 1; i <6; i++) {
    		if(star.getAttribute("class").equals("star fa fa-star")) {
        		numberOfStars= numberOfStars+1;
        		System.out.println("number of stars  + 1");
        	}
        	star= firstCar.findElement(By.xpath("(//span[contains(@class,'go-right mob-fs10')]//i)["+(i+1)+"]"));
		}
    	System.out.println("number of stars: "+ numberOfStars);
    	return numberOfStars;
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
	 * @param starGrade is the property type
	 */
	public void findByStarGrade(int starGrade){
		WebElement grade = driver.findElement(By.xpath("(//input[@id='"+starGrade+"'])[1]/parent::div/ins"));
		grade.click();
		clickSearchFilterButton();
	}
	
	/**
	 * This method clicks on the search button 
	 */
	public void clickSearchFilterButton() {
		searchFilterButton.click();
	}
}
