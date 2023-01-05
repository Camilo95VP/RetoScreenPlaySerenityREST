package setup.apiresources;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.assertj.core.api.Assertions;

import static utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SetUpApiResources {

    public static final String CREATE_RESOURCE_JSON=System.getProperty("user.dir")+"\\src\\test\\resources\\files\\apiresources\\createresource\\createResource.json";
    public static final String UPDATE_RESOURCE_JSON=System.getProperty("user.dir")+"\\src\\test\\resources\\files\\apiresources\\updateresource\\updateResource.json";
    public static final String PARTIAL_UPDATE_RESOURCE_JSON=System.getProperty("user.dir")+"\\src\\test\\resources\\files\\apiresources\\partialupdateresource\\partialUpdateResource.json";
    public static final String URL_BASE="https://jsonplaceholder.typicode.com";
    public static final String RESOURCE="/posts";

    public static final String RESOURCE_PUT_PATCH_DELETE="/posts/1";
    private static final Logger LOGGER=Logger.getLogger(SetUpApiResources.class);

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
