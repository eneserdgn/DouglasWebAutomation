package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class ProductsPage {
    ElementHelper elementHelper;

    public ProductsPage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    private By btn_Filter = By.cssSelector(".facet__title");
    private By filterArea = By.cssSelector(".facet--open");
    private By txtbx_Filter = By.cssSelector(".facet__menu .input__input");
    private By list_Filter = By.cssSelector(".facet-option__checkbox--rating-stars>div");
    private By btn_close = By.cssSelector(".button.button__primary.facet__close-button");
    private By logo = By.cssSelector(".douglas-logo__image.icon.icon--IMAGE");
    private By filterCheckbox = By.cssSelector(".facet-option__checkbox.facet-option__checkbox--selected");
    private By selectedFilters = By.cssSelector(".link.link--text.selected-facets__value.active");

    public void checkProductsPage() {
        elementHelper.waitElementVisible(btn_Filter);
        elementHelper.moveElement(logo);
    }

    public void clickFilter(String filter) {
        elementHelper.moveElement(btn_Filter);
        elementHelper.waitElementClickable(btn_Filter);
        elementHelper.clickElementWithText(btn_Filter, filter);
        try {
            Thread.sleep(1000);
            elementHelper.waitElementVisible(filterArea);
        } catch (Exception e) {
            elementHelper.clickElementWithText(btn_Filter, filter);
            elementHelper.waitElementVisible(filterArea);
        }
    }

    public void sendKeysFilterTextBox(String text) {
        elementHelper.waitElementVisible(txtbx_Filter);
        elementHelper.sendKeys(txtbx_Filter, text);
    }

    public void selectFilter(String filter) {
        elementHelper.clickElementWithText(list_Filter, filter);
        try {
            elementHelper.waitElementVisible(filterCheckbox);
            elementHelper.click(btn_close);
        } catch (Exception e) {
        }
    }

    public void checkFilterCome(String filter) {
        elementHelper.waitElementVisible(selectedFilters);
        elementHelper.checkElementWithText(selectedFilters, filter);

    }
}
