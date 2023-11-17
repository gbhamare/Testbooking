package utils;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(features = { "Features" }, glue = { "test", "pages", "utils" }, 
plugin = {"json:target/cucumber.json"}, 
tags = { "@TS52"}, 
monochrome = true)

public class TestRunner {

}
