package com.TestRunners;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber; 
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions( features = "C:\\Users\\dulee\\eclipse-workspace\\BDDSwiggyDuleekaFinal\\src\\test\\resources\\OrderPizza.feature", 
glue = "com.StepDefinition", 
plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty.html", "json:target/cucumber-reports/CucumberTestReport.json", "timeline:target/test-output-thread/" }, 
//monochrome = true, // display the console output in a proper readable format
dryRun = false
)
public class TestRunner {

}
