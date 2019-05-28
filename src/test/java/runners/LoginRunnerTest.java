package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/login.feature",
        plugin = {"json:target/loginRunner.json"},
        tags = "@login",
        glue = "steps"

    )
public class LoginRunnerTest {
}
