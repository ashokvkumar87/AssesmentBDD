package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = { "stepDefinitions" }, plugin = { "pretty",
		"html:target/HtmlReports/report.html" })
public class TestRunner {

}