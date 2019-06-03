package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/fileupload.feature",
        plugin = {"json:target/uploadRunner.json"},
        tags = "@upload",
        glue = "steps"

)
public class FileUploadRunnerTest {
}
