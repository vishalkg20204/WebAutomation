package support;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.TVHomePage;

public class World {
    public static HomePage homePage;
    public static TVHomePage tvHomePage;
    public static WebDriverHelper webDriverHelper;
    public static StringHelper stringHelper;
    final WebDriver driver = new BrowserCreation().getDriver();

    public void driverClass() {
        World.homePage = new HomePage(driver);
        World.tvHomePage = new TVHomePage(driver);
        World.webDriverHelper = new WebDriverHelper(driver);
        World.stringHelper = new StringHelper(driver);
    }
}
