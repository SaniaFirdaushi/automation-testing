package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.EnvDataReader;

public abstract class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void setup() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
          browser.goTo(EnvDataReader.getEnvData().getBaseUrl());
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            browser.quit();
        }
    }
}
