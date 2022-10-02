package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String browserRequired;
    public static String browserType;
    public static String browserHeadless;
    public static String environment;
    public static String webApplicationUrl;

    public void loadProperties() throws IOException {
        Properties settings = new Properties();
        Properties env = new Properties();
        Properties data = new Properties();

        settings.load(new FileInputStream("config/settings.properties"));
        env.load(new FileInputStream("environment/env.properties"));

        // get the property value and set it to a global variable
        browserRequired = settings.getProperty("browser.required");
        browserType = settings.getProperty("browser.type");
        browserHeadless = settings.getProperty("browser.headless");
        environment = settings.getProperty("environment");
        webApplicationUrl = env.getProperty(environment + ".webUrl");
    }
}
