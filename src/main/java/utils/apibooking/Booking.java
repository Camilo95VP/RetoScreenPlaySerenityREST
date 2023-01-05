package utils.apibooking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;
import utils.Log4jValues;

import java.io.File;

import static utils.apibooking.Paths.REQUEST_JSON_FILE_BOOKING;
import static io.restassured.RestAssured.given;

public class Booking {

    private static final String BASE_URI="https://restful-booker.herokuapp.com";
    protected static final String RESOURCE_CREATE_BOOKING="/booking";
    private static final File requestJsonFileBooking=new File(REQUEST_JSON_FILE_BOOKING.getValue());

    private static final Logger LOGGER=Logger.getLogger(Booking.class);

    private Booking(){
    }

    public static String booking() {
        try {
            PropertyConfigurator.configure(System.getProperty("user.dir")+ Log4jValues.LOG4J_PROPERTIES_FILE_PATH.getValue());
            RestAssured.baseURI=BASE_URI;
            return given()
                    .contentType(ContentType.JSON)
                    .body(requestJsonFileBooking)
                    .when()
                    .post(RESOURCE_CREATE_BOOKING)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("bookingid", Matchers.notNullValue())
                    .extract()
                    .path("bookingid").toString();


        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "";
    }
}
