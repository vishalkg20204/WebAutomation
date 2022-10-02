package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {
                "support",
                "stepDefinitions"
        },
        plugin = {
                "de.monochromata.cucumber.report.PrettyReports:reporting/pretty/Amazon",
                "html:reporting/CucumberHTMLReports/Amazon",
                "json:reporting/cucumberOtherreports/Amazon.json",
                "junit:reporting/cucumber-reports/Amazon.xml",
                "rerun:target/rerun.txt" //Creates a text file with failed scenarios
        },
        strict = true,
        tags = "@test"
)

public class TestRunner {
}