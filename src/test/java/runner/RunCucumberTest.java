package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {},
        features = "src/test/resources/features",
        tags = "not @ignore",
        glue = {"steps"}
)

//metódo para iniciar os testes
public class RunCucumberTest {

}
