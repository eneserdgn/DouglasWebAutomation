package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        tags = "",
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "utils"},
        plugin = {
                "summary",
                "html:target/cucumber-reports.html"
        }
)
public class testRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}