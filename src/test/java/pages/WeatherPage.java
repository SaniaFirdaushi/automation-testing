package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WeatherPage extends Form {
    private final ILabel headerLocation = getElementFactory().getLabel(By.className("header-loc"), "City Name");

    public WeatherPage() {
        super(By.className("card-header"), "Weather Page");
    }

    public String getCityNameFromHeader() {
        return headerLocation.getText();
    }
}
