$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Home/TVHomePage.feature");
formatter.feature({
  "name": "TV Home Page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Amazon | Select the second highest Samsung TV and verify it\u0027s description.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "navigate to Tv Page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Home.TVHomePage_Steps.navigateToTvPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "scroll down the page to Brand filter",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Home.TVHomePage_Steps.scrollDownThePageToBrandFilter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select Samsung as brand",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Home.TVHomePage_Steps.selectSamsungAsBrand()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sort By High to Low option and verify if sorting done",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Home.TVHomePage_Steps.sortByHighToLowOptionAndVerifyIfSortingDone()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on second item and verify it\u0027s description.",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Home.TVHomePage_Steps.clickOnSecondItemAndVerifyItSDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});