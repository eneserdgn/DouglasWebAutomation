package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.General;
import utils.DriverFactory;

public class GeneralDefinitions {

    General general = new General(DriverFactory.getDriver());

    @Given("handle the cookie consent")
    public void handleTheCookieConsent() {
        general.clickAcceptOnCookies();
        general.checkCookiesClosed();

    }

    @When("click on {string} tab")
    public void clickOnTab(String tab) {
        general.clickTabOnNavigationBar(tab);
        general.checkParfumeHighlight();
    }
}
