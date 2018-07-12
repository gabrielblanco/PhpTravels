package tests;

import org.testng.Assert;
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

    @Test(dataProvider = "basicInformatinData", dataProviderClass = data_providers.VisaDataProvider.class)
    public void payUsingPaypal(String uEmail, String uArrivalDate, String uPhoneCode, String uPhoneNumber,
                             String uHomeAddress, String uHomeCountry, String uTravelBy, String uName,
                             String uLastName, String uNationality, String uBirthday, String uGender,
                             String uPassportNumber, String uPassportIssued, String uPassportExpiration,
                             String uIdentificationNumber, String uVisaType, String uCurrency){
        headerObjects = new HeaderObjects(driver);
        visa = new Visa(driver);

        /**
         * Test
         */
        headerObjects.GoToVisa();
        visa.fillBasicInformation(uEmail, uArrivalDate, uPhoneCode, uPhoneNumber, uHomeAddress,
                uHomeCountry, uTravelBy, uName, uLastName, uNationality, uBirthday, uGender, uPassportNumber,
                uPassportIssued, uPassportExpiration, uIdentificationNumber, uVisaType, uCurrency);
        visa.payViaPaypal();
        Assert.assertTrue(visa.isModalDisplayed(),"The modal isn't displayed.");
    }

    /**
     * Tears down the web driver
     */
    @AfterTest
    public void CloseWindow() {
//        driver.close();
    }
}
