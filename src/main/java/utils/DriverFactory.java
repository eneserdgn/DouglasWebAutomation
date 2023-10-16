package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {

    }

    public static void initializeDriver(String browser) {
        WebDriver driver;
        if (driverThreadLocal.get() == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    System.out.println("browser : " + PropertiesReader.getBrowser() + " is invalid, Launching Chrome as browser of choice..");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driverThreadLocal.set(driver);
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertiesReader.getImplicitlyWait()));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PropertiesReader.getPageLoadTimeout()));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(PropertiesReader.getUrl());
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            throw new IllegalStateException("Driver has not been initialized. Call initializeDriver() first.");
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
