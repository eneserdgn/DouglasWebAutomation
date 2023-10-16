package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void clickElementWithText(By by, String text) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        actions.moveToElement(elements.get(0)).build().perform();
        for (WebElement elem : elements) {
            if (elem.getText().contains(text)) {
                elem.click();
                break;
            }
        }
    }

    public void checkElementWithText(By by, String text) {
        boolean check = false;
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        actions.moveToElement(elements.get(0)).build().perform();
        for (WebElement elem : elements) {
            if (elem.getText().contains(text)) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    public void click(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void moveElement(By by) {
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void sendKeys(By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
    }

    public void waitElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitElementClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitElementInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void checkUrl(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }
}
