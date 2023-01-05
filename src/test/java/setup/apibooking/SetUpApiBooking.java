package setup.apibooking;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.assertj.core.api.Assertions;

import static utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SetUpApiBooking {
    public static final String URL_BASE="https://restful-booker.herokuapp.com";
    public static final String RESOURCE="/booking";
    public static final String RESOURCE_TOKEN="/auth";
    public static final String CREATE_TOKEN_JSON=System.getProperty("user.dir")+"\\src\\test\\resources\\files\\apibooking\\createtoken\\createtoken.json";
    private static final Logger LOGGER=Logger.getLogger(SetUpApiBooking.class);

    protected void generalSetUp(String name){
        try{
            setUpLog4j2();
            setUpUser(name);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            Assertions.fail(e.getMessage());
        }

    }

    protected void setUpLog4j2(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    private void setUpUser(String name){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(CallAnApi.at(URL_BASE));
    }

}
