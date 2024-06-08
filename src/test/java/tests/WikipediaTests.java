package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ResultPage;
import utils.BaseTest;

public class WikipediaTests extends BaseTest {

    @DataProvider(name="countryAndTimeZone")
    public static Object[][] getCountryAndTimeZone(){
        return new Object[][]{
                {"México", "UTC-8 a UTC-5"},
                {"Turquía", "TRT (UTC+3)"}
        };
    }

    @Test
    @Parameters({"textToSearch"})
    public void searchTest(String textToSearch){
        ResultPage resultPage = getResultPage(textToSearch);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultPage.isTitleCorrect(textToSearch));
    }

    @Test(dataProvider = "countryAndTimeZone")
    public void validateTimeZoneByCountry(String country, String timeZone){
        ResultPage resultPage = getResultPage(country);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultPage.isTimeZoneCorrect(country, timeZone));

    }

    private ResultPage getResultPage(String textToSearch) {
        HomePage homePage = loadFirstPage();
        return homePage.searchText(textToSearch);
    }


}