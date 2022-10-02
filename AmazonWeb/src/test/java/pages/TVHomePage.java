package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

import static support.World.*;

public class TVHomePage {
    private final WebDriver driver;
    @FindBy(xpath = "//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']")
    private WebElement brand_Samsung;
    @FindBy(xpath = "//span[@dir='auto'][normalize-space()='Smart Televisions']")
    private WebElement category_SmartTV;
    @FindBy(xpath = "//li[@id='p_89/Samsung']//i[@class='a-icon a-icon-checkbox']")
    private WebElement samsung_selected;
    @FindBy(xpath = "//span[normalize-space()=\"Sort by:\"]")
    private WebElement sortByOptions;
    @FindBy(xpath = "(//a[normalize-space()='Price: High to Low'])[1]")
    private WebElement sortBy_HighToLow;

    @FindBy(xpath = "(//div[@class='a-section aok-relative s-image-square-aspect'])[2]")
    private WebElement tv_secondHighestPricedItem;
    @FindBy(xpath = "//span[contains(normalize-space(.), 'Samsung')]")
    private WebElement tv_samsung;
    @FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
    private WebElement tv_samsung_price1;
    @FindBy(xpath = "(//span[@class='a-price-whole'])[2]")
    private WebElement tv_samsung_price2;
    @FindBy(xpath = "//h1[normalize-space()='About this item']")
    private WebElement tv_samsung_AboutThisItem;
    @FindBy(xpath = "//span[@id='productTitle']")
    private WebElement tv_samsung_Title;

    public TVHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToBrandSection() throws InterruptedException, IOException {
        homePage.navigateToHomePage();
        homePage.clickOnHamburgerIcon();
        homePage.clickOnElectronicsCategory();
        homePage.clickOnCategory_TV();
    }

    public void scrollToBrandSection() throws InterruptedException, IOException {
        webDriverHelper.waitUntilVisible(category_SmartTV, 30, 1);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)", brand_Samsung);
        Thread.sleep(6000);
        webDriverHelper.waitUntilVisible(brand_Samsung, 30, 1);
    }

    public void selectSamsungBrand() throws InterruptedException, IOException {
        brand_Samsung.click();
        webDriverHelper.waitUntilVisible(samsung_selected, 30, 1);
        Assert.assertTrue(tv_samsung.isDisplayed(), "Samsung TV lists not displayed");
    }

    public void clickOnSortBy() throws InterruptedException, IOException {
        webDriverHelper.waitUntilVisible(sortByOptions, 30, 1);
        sortByOptions.click();
        webDriverHelper.waitUntilVisible(sortBy_HighToLow, 30, 1);
        Assert.assertTrue(sortBy_HighToLow.isDisplayed(), "Samsung TV lists not sorted");
    }

    public void sortByHighToLow() throws InterruptedException, IOException {
        sortBy_HighToLow.click();
        webDriverHelper.waitUntilVisible(tv_samsung_price2, 30, 1);
    }

    public void verifyAboutThisItem() throws InterruptedException, IOException {
        tv_samsung_price2.click();
        stringHelper.switchWindow();
        webDriverHelper.waitUntilVisible(tv_samsung_Title, 30, 1);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)", tv_samsung_AboutThisItem);
        Thread.sleep(6000);
        Assert.assertTrue(tv_samsung_AboutThisItem.isDisplayed(), "Samsung TV description not displayed");
    }
}
