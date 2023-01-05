package runner.apiresources;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets =CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        glue={"stepdefinition.apiresources.updateresource"},
        features = {"src/test/resources/features/apiresources/updateresource/updateResource.feature"}
)
public class UpdateResourceTest {
}
