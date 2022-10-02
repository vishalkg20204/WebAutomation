package support;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WebDriverHelper {
    public static Wait<WebDriver> wait;
    private final WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisible(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class).ignoring(TimeoutException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
