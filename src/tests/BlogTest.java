package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.BlogPage;
import pageobjects.HeaderObjects;

public class BlogTest extends BaseTest{
	
	BlogPage blogPage;
	HeaderObjects headerObjects;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	/**
	 * TC13-Verify that system shows a No Result Found message when no blog was found.
	 * @throws InterruptedException
	 */
	@Test()
	public void NoResultsFound() throws InterruptedException {
		headerObjects=new HeaderObjects(driver);
		headerObjects.GoToBlog();
		Thread.sleep(3000);
		blogPage= new BlogPage(driver);
		blogPage.quickSearch("Virgin");
		Thread.sleep(3000);
		assertTrue(blogPage.noResultdDisplayed());
	}
	
	/**
	 * This test close the browser window
	 */
	@AfterTest
	public void CloseWindow() {
		//driver.close();
	}
}