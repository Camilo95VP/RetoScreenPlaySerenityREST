package stepdefinition.apipokemon.getberries;

import setup.apipokemon.SetUpApiPokemon;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;

import java.nio.charset.StandardCharsets;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static questions.common.ResponseCode.was;
import static questions.common.ReturnStringValue.returnStringValue;
import static tasks.DoGet.doGet;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GetBerriesStepDefinition extends SetUpApiPokemon {

    public static final String ROL="Desarrollador";

    @Dado("que el desarrollador navegó hasta el recurso web")
    public void queElDesarrolladorNavegoHastaElRecursoWeb() {
        generalSetUp(ROL);
    }
    @Cuando("el administrador realice la petición de obtener bayas")
    public void elAdministradorRealiceLaPeticionDeObtenerBayas() {
        theActorInTheSpotlight().attemptsTo(
                doGet().usingResource(RESOURCE)
        );
    }
    @Entonces("visualizará las bayas creadas y un resultado exitoso de la operación")
    public void visualizaraLasBayasCreadasYUnResultadoExitosoDeLaOperacion() {
        String restResponse=new String(LastResponse.received().answeredBy(theActorInTheSpotlight()).asByteArray(), StandardCharsets.UTF_8);

        theActorInTheSpotlight().should(
                seeThat("el código de respuesta",was(),equalTo(HttpStatus.SC_OK))
        );

        theActorInTheSpotlight().should("El nombre de la baya es cheri",
                seeThat(returnStringValue(restResponse),containsString("cheri"))
        );
    }

}
