package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class HomePage {
    ElementHelper elementHelper;

    public HomePage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void checkHomePage() {
        elementHelper.checkUrl("https://www.douglas.de/de");
    }
}
