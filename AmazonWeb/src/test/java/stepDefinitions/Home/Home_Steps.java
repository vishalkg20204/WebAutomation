package stepDefinitions.Home;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static support.World.homePage;

public class Home_Steps {

    @Given("open the amazon india website")
    public void openTheAmazonIndiaWebsite() throws IOException, InterruptedException {
        homePage.navigateToHomePage();
    }

    @When("click on ALL button")
    public void clickOnALLButton() throws IOException, InterruptedException {
        homePage.clickOnHamburgerIcon();
    }

    @Then("click on Electronics category")
    public void clickOnElectronicsCategory() throws IOException, InterruptedException {
        homePage.clickOnElectronicsCategory();
    }

    @Then("click on Tv Category and verify the page")
    public void clickOnTvCategoryAndVerifyThePage() throws IOException, InterruptedException {
        homePage.clickOnCategory_TV();
    }
}
