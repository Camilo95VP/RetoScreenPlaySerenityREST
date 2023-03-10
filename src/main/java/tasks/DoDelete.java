package tasks;

import interactions.Delete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.Map;

public class DoDelete implements Task {

    private String resource;

    private Map<String,Object> headers=new HashMap<>();

    public DoDelete usingTheResource(String resource){
        this.resource=resource;
        return this;
    }

    public DoDelete withHeaders(Map<String,Object> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(resource).with(requestSpecification -> requestSpecification
                .headers(headers)));
    }

    public static DoDelete doDelete(){
        return new DoDelete();
    }
}
