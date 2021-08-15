package testRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features\\",
glue = { "stepDefinitions" },
dryRun = false, 
tags = {"@signup"},
plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReports/SignupTest.html"}
)

public class TestRunner {

}
