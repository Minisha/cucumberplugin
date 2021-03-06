package hellocucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "hellocucumber.listener.StepListener",
        "json:target/cucumber.json",
        "html:target/cucumber-reports.html" })
public class RunCucumberTest {

}

