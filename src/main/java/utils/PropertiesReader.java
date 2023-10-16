package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties = new Properties();

    public static String getProperty(String key) {
        String value = "";
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
            value = properties.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }


    public static String getUrl() {
        return getProperty("url");
    }

    public static String getBrowser() {
        return getProperty("browser").toLowerCase();
    }

    public static int getImplicitlyWait() {
        return Integer.valueOf(getProperty("implicitlyWait"));
    }

    public static int getPageLoadTimeout() {
        return Integer.valueOf(getProperty("pageLoadTimeOut"));
    }

}
