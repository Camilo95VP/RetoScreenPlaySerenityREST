package tasks;

import interactions.Post;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.Map;

public class DoPost implements Task {

    private Map<String,Object> headers=new HashMap<>();
    private String bodyRequest;
    private String resource;

    public DoPost andBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }

    public DoPost usingTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPost withHeaders(Map<String,Object> headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(resource).with(requestSpecification -> requestSpecification
                .headers(headers).body(bodyRequest)));
    }

    public static DoPost doPost(){
        return new DoPost();
    }
}
