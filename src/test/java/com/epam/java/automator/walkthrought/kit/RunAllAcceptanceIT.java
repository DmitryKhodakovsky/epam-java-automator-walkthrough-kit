package com.epam.java.automator.walkthrought.kit;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
    "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
    "pretty", "html:target/site/cucumber-pretty.html"
})
public class RunAllAcceptanceIT {
}
