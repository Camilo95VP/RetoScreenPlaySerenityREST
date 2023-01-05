package tasks;

import interactions.Put;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.Map;

public class DoPut implements Task {

    private Map<String,Object> headers=new HashMap<>();
    private String bodyRequest;
    private String resource;

    public DoPut andBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }

    public DoPut usingTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPut withHeaders(Map<String,Object> headers) {
        this.headers = headers;
        return this;
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(resource).with(requestSpecification -> requestSpecification
                .headers(headers).body(bodyRequest)));
        
    }
    
    public static DoPut doPut(){
        return new DoPut();
    }
}
