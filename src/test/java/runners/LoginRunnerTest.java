package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = "steps",
        plugin = {"json:target/cucumber.json"}
    )
public class LoginRunnerTest {
}
