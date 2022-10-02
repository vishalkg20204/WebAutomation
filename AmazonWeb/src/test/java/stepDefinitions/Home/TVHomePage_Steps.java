package stepDefinitions.Home;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static support.World.tvHomePage;

public class TVHomePage_Steps {
    @Given("navigate to Tv Page")
    public void navigateToTvPage() throws IOException, InterruptedException {
        tvHomePage.navigateToBrandSection();
    }

    @Then("scroll down the page to Brand filter")
    public void scrollDownThePageToBrandFilter() throws IOException, InterruptedException {
        tvHomePage.scrollToBrandSection();
    }

    @Then("select Samsung as brand")
    public void selectSamsungAsBrand() throws IOException, InterruptedException {
        tvHomePage.selectSamsungBrand();
    }

    @Then("sort By High to Low option and verify if sorting done")
    public void sortByHighToLowOptionAndVerifyIfSortingDone() throws IOException, InterruptedException {
        tvHomePage.clickOnSortBy();
        tvHomePage.sortByHighToLow();
    }

    @Then("click on second item and verify it's description.")
    public void clickOnSecondItemAndVerifyItSDescription() throws IOException, InterruptedException {
        tvHomePage.verifyAboutThisItem();
    }
}
