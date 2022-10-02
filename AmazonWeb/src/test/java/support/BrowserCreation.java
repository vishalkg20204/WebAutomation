package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class BrowserCreation {

    public static WebDriver driver;
    final PropertiesReader propertiesReader = new PropertiesReader();
    final ChromeOptions options = new ChromeOptions();

    @Before
    public void setUp(Scenario scenario) throws IOException {
        propertiesReader.loadProperties();
        if (PropertiesReader.browserHeadless.equals("true")) {
            options.addArguments("--window-size=1325x744");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-dev-shm-usage");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            System.out.println(scenario.toString());
        }
        if (PropertiesReader.browserRequired.equals("true")) {
            if (PropertiesReader.browserType.equals("chrome")) {
                options.addArguments("start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--silent");
                options.addArguments("--log-level=3");
                options.addArguments("--disable-extensions");
                options.addArguments("--test-type");
                options.addArguments("--disable-dev-shm-usage");
                options.setPageLoadStrategy(PageLoadStrategy.NONE);
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                driver = new ChromeDriver(options);
                System.out.println(scenario.toString());
            }
        }
        new World().driverClass();
    }

    @After
    public void embedScreenshot(Scenario scenario) throws InterruptedException {
        //If test fails takes a screenshot and embeds it in the Cucumber report
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                scenario.embed(screenshot, "image/png");
                scenario.write(testName);
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        driver.quit();
    }

    public void tearDown() {
        if (PropertiesReader.browserRequired.equals("true")) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

