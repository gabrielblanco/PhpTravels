package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	WebDriver driver;
	@FindBy(name="username") WebElement userName;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath ="//div[@data-wow-duration='1s']//button[@type='submit']")  	WebElement submit_button;
	@FindBy(linkText="Login Details Incorrect. Please try again.")	WebElement errorMsgTxt;
	@FindBy(xpath= "//a[@class='btn btn-default btn-block form-group']") WebElement btnSignUp;
	@FindBy(xpath= "//a[@class='btn btn-default btn-block']") WebElement btnForgetPassword;

	/**
	 * This is the constructor method 
	 * @param driverP
	 */
	public LoginPage(WebDriver driverP) {
		driver= driverP;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method gets the pageTitle
	 * @return
	 */
	public String getloginPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	/**
	 * This method verifies if the user is the login page
	 * @return
	 */
	public boolean verifyloginInPageTitle() {
		String expectedTitle = "PHPTRAVELS";
		return getloginPageTitle().contains(expectedTitle);
	}
	/**
	 * This method verify if the user can login in the website
	 * @return
	 */
	public void Login(String email,String password) {
		enterUserEmail(email);
		enterUserPassword(password);
		clickOnLogin();		
	}
	/**
	 * this method displays the forget password pop up
	 */
	public void ClickOnForgetPassword() {
		btnForgetPassword.click();
	}
	/**
	 * This method redirects the user to the sign up view
	 */
	public void ClickOnSignUp() {
		btnSignUp.click();
	}
	/**
	 * This method enters the user's email
	 * @param email
	 */
	public void enterUserEmail(String email) {
		this.userName.clear();
		this.userName.sendKeys(email);
	}
	/**
	 * This method enters the user's password
	 * @param email
	 */
	public void enterUserPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	/**
	 * This method click on the Login button
	 * @param email
	 */
	public void clickOnLogin() {
		this.submit_button.click();
	}
	/**
	 * this method verifies if a error message is displayed
	 * @return
	 */
	public String getErrorMessage() {
		String strErrorMsg = null;
		WebElement errorMsg = errorMsgTxt;
		if(errorMsg.isDisplayed())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	}
}

