package questions.apiresources;

import models.apiresources.Resource;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResourceQuestion implements Question<Resource> {
    @Override
    public Resource answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Resource.class);
    }

    public static ResourceQuestion resourceQuestion(){
        return new ResourceQuestion();
    }
}
