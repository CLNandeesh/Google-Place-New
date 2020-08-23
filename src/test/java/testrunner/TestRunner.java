package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "./\\src\\test\\java\\features" }, glue = {
		"stepdefnitions" },plugin="json:target/jsonReports/cucumber-report.json",  monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
