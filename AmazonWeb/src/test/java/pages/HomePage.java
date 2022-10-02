package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.PropertiesReader;

import java.io.IOException;

import static support.World.webDriverHelper;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement hamburger_ALL;
    @FindBy(xpath = "//div[normalize-space()='TV, Appliances, Electronics']")
    private WebElement category_TV_Electronics;
    @FindBy(xpath = "//a[normalize-space()='Televisions']")
    private WebElement category_TV;
    @FindBy(xpath = "//span[@dir='auto'][normalize-space()='Smart Televisions']")
    private WebElement category_SmartTV;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() throws InterruptedException, IOException {
        driver.get(PropertiesReader.webApplicationUrl);
        webDriverHelper.waitUntilVisible(hamburger_ALL, 30, 1);
        Assert.assertTrue(hamburger_ALL.isDisplayed(), "Hamburger icon not displayed");
    }

    public void clickOnHamburgerIcon() throws InterruptedException, IOException {
        hamburger_ALL.click();
        webDriverHelper.waitUntilVisible(category_TV_Electronics, 30, 1);
        Assert.assertTrue(category_TV_Electronics.isDisplayed(), "Electronics category not displayed");
    }

    public void clickOnElectronicsCategory() throws InterruptedException, IOException {
        category_TV_Electronics.click();
        webDriverHelper.waitUntilVisible(category_TV, 30, 1);
    }

    public void clickOnCategory_TV() throws InterruptedException, IOException {
        category_TV.click();
        webDriverHelper.waitUntilVisible(category_SmartTV, 30, 1);
        Assert.assertTrue(category_SmartTV.isDisplayed(), "Smart TV category not displayed");
    }

}
