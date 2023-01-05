package stepdefinition.apibooking.deletebooking;

import setup.apibooking.SetUpApiBooking;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.http.HttpStatus;

import java.util.HashMap;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static questions.common.ResponseCode.was;
import static tasks.DoDelete.doDelete;
import static utils.apibooking.Booking.booking;
import static utils.apibooking.Token.token;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class DeleteBookingStepDefinition extends SetUpApiBooking {

    private final HashMap<String,Object> headers=new HashMap<>();
    private static final String ROL_NAME= "Administrador";

    @Dado("que el administrador navegó hasta el recurso web y suministre los datos para eliminar la reserva")
    public void queElAdministradorNavegoHastaElRecursoWebYSuministreLosDatosParaEliminarLaReserva() {
        generalSetUp(ROL_NAME);
        headers.put("Content-type","application/json");
        headers.put("Cookie","token="+token());
    }
    @Cuando("el administrador realice la petición de eliminar reserva")
    public void elAdministradorRealiceLaPeticionDeEliminarReserva() {
        theActorInTheSpotlight().attemptsTo(
                doDelete()
                        .usingTheResource(RESOURCE+"/"+booking())
                        .withHeaders(headers)
        );
    }
    @Entonces("visualizará que se eliminó correctamente la reserva")
    public void visualizaraQueSeEliminoCorrectamenteLaReserva() {
        theActorInTheSpotlight().should(
                seeThat("el código de respuesta",was(),equalTo(HttpStatus.SC_CREATED))
        );
    }

}
