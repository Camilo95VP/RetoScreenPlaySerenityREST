package runner.apibooking;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets =CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        glue={"stepdefinition.apibooking.createtoken"},
        features = {"src/test/resources/features/apibooking/createtoken/createToken.feature"}
)
public class CreateTokenTest {

}
