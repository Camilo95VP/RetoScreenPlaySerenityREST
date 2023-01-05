package stepdefinition.apibooking.createtoken;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import setup.apibooking.SetUpApiBooking;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static questions.common.ResponseCode.was;
import static questions.common.ReturnStringValue.returnStringValue;
import static tasks.DoPost.doPost;
import static utils.FileUtilities.readFile;

public class CreateTokenStepDefinition extends SetUpApiBooking {

    private final HashMap<String,Object> headers=new HashMap<>();
    private static final String ROL_NAME= "Administrador";
    private String bodyRequest;

    @Dado("que el administrador navegó hasta el recurso web y suministre los datos para crear el token")
    public void queElAdministradorNavegoHastaElRecursoWebYSuministreLosDatosParaCrearElToken() {
        generalSetUp(ROL_NAME);
        headers.put("Content-type","application/json");
        bodyRequest=defineBodyRequest();
    }
    @Cuando("el administrador realice la petición de crear token")
    public void elAdministradorRealiceLaPeticionDeCrearToken() {
        theActorInTheSpotlight().attemptsTo(
                doPost()
                        .usingTheResource(RESOURCE_TOKEN)
                        .withHeaders(headers)
                        .andBodyRequest(bodyRequest)
        );
    }
    @Entonces("visualizará que se creo correctamente el token")
    public void visualizaraQueSeCreoCorrectamenteElToken() {
        String restResponse=new String(LastResponse.received().answeredBy(theActorInTheSpotlight()).asByteArray(), StandardCharsets.UTF_8);

        theActorInTheSpotlight().should(
                seeThat("el código de respuesta",was(),equalTo(HttpStatus.SC_OK))
        );

        theActorInTheSpotlight().should("El token no es nulo",
                seeThat(returnStringValue(restResponse),containsString("token"))
        );
    }

    private String defineBodyRequest(){
        return readFile(CREATE_TOKEN_JSON);
    }
}
