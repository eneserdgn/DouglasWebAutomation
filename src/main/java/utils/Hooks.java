package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before() {
        DriverFactory.initializeDriver(PropertiesReader.getBrowser());
    }

    @After
    public void after() {
        DriverFactory.quitDriver();
    }

}
