package tasks;

import interactions.Patch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.Map;

public class DoPatch implements Task {

    private Map<String,Object> headers=new HashMap<>();
    private String bodyRequest;
    private String resource;

    public DoPatch andBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }

    public DoPatch usingTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPatch withHeaders(Map<String,Object> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to(resource).with(requestSpecification -> requestSpecification
                .headers(headers).body(bodyRequest)));
    }

    public static DoPatch doPatch(){
        return new DoPatch();
    }
}
