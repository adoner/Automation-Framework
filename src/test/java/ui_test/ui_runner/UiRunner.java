package ui_test.ui_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/ui_feature",
        glue = "ui_test/ui_stepdefinitions",
        tags = "@task3-2",
        dryRun = false,
        plugin={"pretty","json:target/uiReport.json","html:target/uiReport.html","rerun:target/uiFailedTests.txt"})
public class UiRunner {
}
