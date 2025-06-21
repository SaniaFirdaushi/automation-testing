package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import constants.MeasurementUnits;
import org.openqa.selenium.By;

public class SettingPage extends Form {
    private final IButton settings = getElementFactory().getButton(By.className("icon-settings"), "Setting Link");
    private final IComboBox unitDropdown = getElementFactory().getComboBox(By.id("unit"), "Temperature unit dropdown");

    public SettingPage() {
        super(By.className("settings"), "Temperature Page");
    }

    public void clickSetting() {
        settings.click();
    }

    public void selectUnit(MeasurementUnits unit) {
        unitDropdown.selectByValue(unit.getLabel());
    }
}
