package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.HomePage;
import utils.DriverFactory;

public class HomePageDefinitions {

    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("user is on the Home Page")
    public void userIsOnTheHomePage() {
        homePage.checkHomePage();
    }
}
