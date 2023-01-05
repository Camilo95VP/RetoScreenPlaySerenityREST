package questions.apibooking;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import questions.apiresources.ResourceQuestion;
import models.apibooking.Booking;

public class BookingQuestion implements Question<Booking> {
    @Override
    public Booking answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Booking.class);
    }

    public static ResourceQuestion bookingQuestion(){
        return new ResourceQuestion();
    }
}