package tests;

import aquality.selenium.browser.AqualityServices;
import constants.MeasurementUnits;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SettingPage;

public class TemperatureTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final SettingPage settingPage = new SettingPage();

    @Test
    public void temperatureTest() {
        mainPage.clickPrivacyButton();

        Assert.assertEquals(mainPage.getTempUnit(), MeasurementUnits.METRIC.getLabel(), "Temperature unit is not in Metric (C)");

        mainPage.clickHeaderMenu();

        settingPage.clickSetting();

        Assert.assertTrue(AqualityServices.getConditionalWait().waitFor(() -> settingPage.state().isDisplayed()), "Setting Page is not displayed");

        settingPage.selectUnit(MeasurementUnits.IMPERIAL);

        browser.goBack();
        String newUnit = mainPage.getTempUnit();
        Assert.assertEquals(newUnit, MeasurementUnits.IMPERIAL.getLabel(), "Temperature unit is not in imperial (F)");
    }
}
