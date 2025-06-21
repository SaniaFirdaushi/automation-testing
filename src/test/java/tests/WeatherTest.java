package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WeatherPage;

public class WeatherTest extends BaseTest {
    private final String searchLocation = "New York";
    private final MainPage mainPage = new MainPage();
    private final WeatherPage weatherPage = new WeatherPage();

    @Test
    public void testWeather() {
        mainPage.clickPrivacyButton();

        mainPage.searchInput(searchLocation);
        Assert.assertTrue(mainPage.isSearchResultDisplayed(), "Search result is not displayed");

        mainPage.clickFirstSearchResult();
        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(() -> weatherPage.state().isDisplayed()), "City weather page is not displayed");

        Assert.assertTrue(weatherPage.getCityNameFromHeader().contains(searchLocation), "The city weather page header does not contain the city name from the search.");
    }
}
