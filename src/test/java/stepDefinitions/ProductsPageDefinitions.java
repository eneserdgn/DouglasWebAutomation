package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;
import utils.DriverFactory;

public class ProductsPageDefinitions {

    ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

    @When("select on {string} Marke on Products Page")
    public void selectOnMarkeOnProductsPage(String marke) {
        if (!marke.isEmpty()) {
            productsPage.clickFilter("Marke");
            productsPage.sendKeysFilterTextBox(marke);
            productsPage.selectFilter(marke);
            productsPage.checkFilterCome(marke);
        }
    }

    @When("select on {string} Produktart on Products Page")
    public void selectOnProducartOnProductsPage(String producart) {
        if (!producart.isEmpty()) {
            productsPage.clickFilter("Produktart");
            productsPage.sendKeysFilterTextBox(producart);
            productsPage.selectFilter(producart);
            productsPage.checkFilterCome(producart);
        }
    }

    @When("select on {string} Geschenk für on Products Page")
    public void selectOnGeschenkFurOnProductsPage(String geschenkFur) {
        if (!geschenkFur.isEmpty()) {
            productsPage.clickFilter("Geschenk für");
            productsPage.sendKeysFilterTextBox(geschenkFur);
            productsPage.selectFilter(geschenkFur);
            productsPage.checkFilterCome(geschenkFur);
        }
    }

    @When("select on {string} Für Wen on Products Page")
    public void selectOnFurWenOnProductsPage(String furWen) {
        if (!furWen.isEmpty()) {
            productsPage.clickFilter("Für Wen");
            productsPage.selectFilter(furWen);
            productsPage.checkFilterCome(furWen);
        }
    }

    @Then("should see the Products Page")
    public void shouldSeeTheProductsPage() {
        productsPage.checkProductsPage();
    }

    @When("select on {string} Highlights on Products Page")
    public void selectOnHighlightsOnProductsPage(String highlights) {
        if (!highlights.isEmpty()) {
            productsPage.clickFilter("Highlights");
            productsPage.selectFilter(highlights);
            productsPage.checkFilterCome(highlights);
        }
    }
}
