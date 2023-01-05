package runner.apiresources;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets =CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        glue={"stepdefinition.apiresources.partialupdateresource"},
        features = {"src/test/resources/features/apiresources/partialupdateresource/partialUpdateResource.feature"}
)
public class PartialUpdateResourceTest {
}
