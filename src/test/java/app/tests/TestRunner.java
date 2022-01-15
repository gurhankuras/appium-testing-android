package app.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "app.tests",
        plugin = {"json:target/cucumber.json"},
        tags = "@happyPath"
)
public class TestRunner {
}
