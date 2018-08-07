package data_providers;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	@DataProvider(name = "loginAuthentication")
    public static Object[][] credentials(){
        return new Object[][] {
        	{"user@phptravels.com", "demouser","https://www.phptravels.net/account/"}
         };
    }
	@DataProvider(name = "loginAuthenticationWithOutURL")
    public static Object[][] loginData(){
        return new Object[][] {
        	{"user@phptravels.com", "demouser"}
         };
    }
    @DataProvider(name = "editAccountData")
    public static Object[][] accountData(){
        return new Object[][] {
                {"user@phptravels.com", "demouser", "89786765", "test@phptravels.com", "passwordTest", "passwordTest",
                        "Street 1, Park Avenue", "Street 2, Midway Avenue", "Dallas", "Texas", "51205", "Costa Rica"}
        };
    }
}
