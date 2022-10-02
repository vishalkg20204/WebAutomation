package support;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

import static support.BrowserCreation.driver;

public class StringHelper {
    public StringHelper(WebDriver driver) {
    }

    public void switchWindow() throws InterruptedException, IOException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}
