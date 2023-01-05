package tasks;

import interactions.Get;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoGet implements Task {

    private String resource;

    public DoGet usingResource(String resource){
        this.resource=resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
        );
    }

    public static DoGet doGet(){
        return new DoGet();
    }
}
