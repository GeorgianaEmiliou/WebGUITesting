package ge.sparta.com.pom.cucumber;

import io.cucumber.junit.Cucumber; //cucumber-junit
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith; //junit-vintage-engine

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/report.html", "json:target/report,json"},
        publish = true
)
public class TestRunner {}
