package runner.apipokemon;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets =CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        glue={"stepdefinition.apipokemon.getberries"},
        features = {"src/test/resources/features/apipokemon/getberries/getBerries.feature"}
)
public class GetBerriesTest {
}
