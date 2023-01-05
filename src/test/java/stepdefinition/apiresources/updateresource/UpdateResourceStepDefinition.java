package stepdefinition.apiresources.updateresource;

import setup.apiresources.SetUpApiResources;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static questions.apiresources.ResourceQuestion.resourceQuestion;
import static questions.common.ResponseCode.was;
import static questions.common.ReturnStringValue.returnStringValue;
import static tasks.DoPut.doPut;
import static utils.FileUtilities.readFile;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateResourceStepDefinition extends SetUpApiResources {

    private final HashMap<String,Object> headers=new HashMap<>();
    private static final String ROL_NAME= "Administrador";
    private String bodyRequest;
    @Dado("que el administrador navegó hasta el recurso web y suministre los datos para actualizar el recurso")
    public void queElAdministradorNavegoHastaElRecursoWebYSuministreLosDatosParaActualizarElRecurso() {
        generalSetUp(ROL_NAME);
        headers.put("Content-type","application/json; charset=UTF-8");
        bodyRequest=defineBodyRequest();
    }
    @Cuando("el administrador realice la petición de actualizar recurso")
    public void elAdministradorRealiceLaPeticionDeActualizarRecurso() {
        theActorInTheSpotlight().attemptsTo(
                doPut().usingTheResource(RESOURCE_PUT_PATCH_DELETE)
                        .withHeaders(headers)
                        .andBodyRequest(bodyRequest)
        );
    }
    @Entonces("visualizará que se actualizo correctamente el recurso")
    public void visualizaraQueSeActualizoCorrectamenteElRecurso() {

        String restResponse=new String(LastResponse.received().answeredBy(theActorInTheSpotlight()).asByteArray(), StandardCharsets.UTF_8);

        theActorInTheSpotlight().should(
                seeThat("el código de respuesta",was(),equalTo(HttpStatus.SC_OK))
        );

        theActorInTheSpotlight().should(
                seeThat("el recurso no es nulo",resourceQuestion(),notNullValue())
        );

        theActorInTheSpotlight().should("El userId es 1, el titulo es foo y el body es bar",
                seeThat(returnStringValue(restResponse),containsString("1")),
                seeThat(returnStringValue(restResponse),containsString("foo")),
                seeThat(returnStringValue(restResponse),containsString("bar"))
        );
    }

    private String defineBodyRequest(){
        return readFile(UPDATE_RESOURCE_JSON);
    }
}
