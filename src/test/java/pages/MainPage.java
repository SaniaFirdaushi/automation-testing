package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;

public class MainPage extends Form {
    private final IButton privacyButton = getElementFactory().getButton(By.cssSelector(".banner-button.policy-accept"), "Privacy Banner Button");
    private final ITextBox searchByInput = getElementFactory().getTextBox(By.className("search-input"), "Search Input");
    private final By searchResult = By.cssSelector(".search-bar-result.search-result.source-radar");
    private final ILabel tempUnit = getElementFactory().getLabel(By.className("recent-location-temp-unit"), "Temperature Unit");
    private final IButton headerMenu = getElementFactory().getButton(By.className("hamburger-button"), "Hamburger Icon");

    public MainPage() {
        super(By.className("recent-location-item"), "Main page");
    }

    public void clickPrivacyButton() {
        privacyButton.click();
    }

    public void searchInput(String searchLocation) {
        searchByInput.type(searchLocation);
    }

    private List<ILabel> getSearchResultItems() {
        return getElementFactory().findElements(searchResult, ElementType.LABEL);
    }

    public boolean isSearchResultDisplayed() {
        return AqualityServices.getConditionalWait().waitFor(() -> !getSearchResultItems().isEmpty());
    }

    public void clickFirstSearchResult() {
        getSearchResultItems().get(0).click();
    }

    public String getTempUnit() {
        return tempUnit.getText().trim();
    }

    public void clickHeaderMenu() {
        headerMenu.click();
    }
}
