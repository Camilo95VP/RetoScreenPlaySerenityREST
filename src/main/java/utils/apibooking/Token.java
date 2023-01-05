package utils.apibooking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;

import java.io.File;

import static utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static utils.apibooking.Paths.REQUEST_JSON_FILE_TOKEN;
import static io.restassured.RestAssured.given;

public class Token {

    private static final String BASE_URI="https://restful-booker.herokuapp.com";

    protected static final String RESOURCE_TOKEN="/auth";

    private static final File requestJsonFileToken=new File(REQUEST_JSON_FILE_TOKEN.getValue());

    private static final Logger LOGGER=Logger.getLogger(Token.class);

    private Token(){}

    public static String token(){
        try{
            PropertyConfigurator.configure(System.getProperty("user.dir")+LOG4J_PROPERTIES_FILE_PATH.getValue());
            RestAssured.baseURI=BASE_URI;
            return given()
                    .contentType(ContentType.JSON)
                    .body(requestJsonFileToken)
                    .when()
                    .post(RESOURCE_TOKEN)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("token", Matchers.notNullValue())
                    .extract()
                    .path("token");
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }
        return "";
    }





}
