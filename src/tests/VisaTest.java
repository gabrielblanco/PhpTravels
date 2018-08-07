package tests;

import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HeaderObjects;
import pageobjects.visa.Visa;

public class VisaTest extends BaseTest {

    /**
     * Instances
     */
    HeaderObjects headerObjects;
    Visa visa;

    /**
     * Initialize the web driver.
     */
    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }

    @Test(dataProvider = "basicInformatinData", dataProviderClass = data_providers.VisaDataProvider.class, enabled = false)
    public void payUsingPaypal(String uEmail, String uArrivalDate, String uPhoneCode, String uPhoneNumber,
                             String uHomeAddress, String uHomeCountry, String uTravelBy, String uName,
                             String uLastName, String uNationality, String uBirthday, String uGender,
                             String uPassportNumber, String uPassportIssued, String uPassportExpiration,
                             String uIdentificationNumber, String uVisaType, String uCurrency){
        headerObjects = new HeaderObjects(driver);
        visa = new Visa(driver);

        headerObjects.GoToVisa();
        visa.fillBasicInformation(uEmail, uArrivalDate, uPhoneCode, uPhoneNumber, uHomeAddress,
                uHomeCountry, uTravelBy, uName, uLastName, uNationality, uBirthday, uGender, uPassportNumber,
                uPassportIssued, uPassportExpiration, uIdentificationNumber, uVisaType, uCurrency);
        visa.payViaPaypal();
        Assert.assertTrue(visa.isModalDisplayed(),"The modal isn't displayed.");
    }

    /**
     * Verifies that basic information input fields are required.
     */
    @Test
    public void varifyRequiredInputFields() {
        headerObjects= new HeaderObjects(driver);
        headerObjects.GoToVisa();
        visa = new Visa(driver);
        Assert.assertTrue(visa.verifyRequiredFields());
    }
    
    /**
     * The test case verifies that the user can remove an applicant when more than one applicant exist.
     * @throws InterruptedException
     */
    @Test (enabled = false)
    public void removeApplicant() throws InterruptedException {
    	headerObjects= new HeaderObjects(driver);
    	headerObjects.GoToVisa();
    	Thread.sleep(3000);
    	visa= new Visa(driver);
    	visa.addApplicant();
    	Thread.sleep(3000);
    	int oldNumberOfApplicants= visa.getNumberOfApliccants();
    	visa.removeApplicant();
    	int actualNumberOfApplicants =visa.getNumberOfApliccants();
    	assertEquals(actualNumberOfApplicants, oldNumberOfApplicants-1,"Applicant isn't removed");
    }

    /**
     * Tears down the web driver
     */
//    @AfterTest
//    public void CloseWindow() {
//        driver.close();
//    }
}
