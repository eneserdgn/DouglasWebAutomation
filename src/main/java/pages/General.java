package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class General {
    ElementHelper elementHelper;

    public General(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    private By btn_AcceptOnCookie = By.cssSelector(".button.button__primary.uc-list-button__accept-all");
    private By area_Cookies = By.cssSelector(".modal-overlay__root.modal-overlay__general.uc-banner-modal.modal-overlay__transition-appear-done.modal-overlay__transition-enter-done");
    private By list_tabsOnNavigationBar = By.cssSelector(".link.link--nav-heading.navigation-main-entry__link");
    private By parfumeHighlight = By.cssSelector(".navigation-main-entry--active");

    public void clickTabOnNavigationBar(String tab) {
        elementHelper.clickElementWithText(list_tabsOnNavigationBar, tab);
    }

    public void clickAcceptOnCookies() {
        elementHelper.click(btn_AcceptOnCookie);
    }

    public void checkCookiesClosed() {
        elementHelper.waitElementInvisible(area_Cookies);
    }

    public void checkParfumeHighlight(){
        elementHelper.waitElementVisible(parfumeHighlight);
    }

}
