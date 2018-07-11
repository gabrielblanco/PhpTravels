package data_providers;

import org.testng.annotations.DataProvider;

public class VisaDataProvider {

    @DataProvider(name = "basicInformatinData")
    public static Object[][] basicInformationData(){
        return new Object[][] {
                {"gabriel@example.com", "26", "506", "88665544", "Quesada City, 21001, Costa Rica.",
                "Costa Rica (CR)", "air", "Gabriel", "Duran", "Spain (ES)", "1995-07-06", "Male", "P4366918",
                        "2008-06-10", "2030-10-11"}
        };
    }

}
