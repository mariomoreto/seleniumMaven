package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/fileUpload.feature",
        glue = "steps",
        plugin = {"json:target/fileUpload.json"}
)
public class FileUploadRunnerTest {
}
