package runner.apibooking;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets =CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        glue={"stepdefinition.apibooking.deletebooking"},
        features = {"src/test/resources/features/apibooking/deletebooking/deleteBooking.feature"}
)
public class DeleteBookingTest {
}
