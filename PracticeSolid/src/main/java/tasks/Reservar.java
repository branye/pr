package tasks;

import interactions.MultipleClicks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.util.List;

import static java.lang.Integer.parseInt;
import static userinterfaces.SeleccionarHotelPage.*;

public class Reservar implements Task {
    private List<List<String>> hotel;

    public Reservar(List<List<String>> hotel) {
        this.hotel = hotel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DESTINATION));
        actor.attemptsTo(Click.on(OPT_DUBAI));
        actor.attemptsTo(Enter.theValue(hotel.get(1).get(0)).into(DATE_CHECK_IN));
        actor.attemptsTo(Enter.theValue(hotel.get(1).get(1)).into(DATE_CHECK_OUT).thenHit(Keys.TAB));
        actor.attemptsTo(MultipleClicks.toElement(BTN_NUMBER_ADULTS, parseInt(hotel.get(1).get(2))));
        actor.attemptsTo(MultipleClicks.toElement(BTN_NUMBER_CHILD, parseInt(hotel.get(1).get(3))));
        actor.attemptsTo(Click.on(BTN_SEARCH));
    }

    public static Reservar hotel(List<List<String>> hotel) {
        return Tasks.instrumented(Reservar.class, hotel);
    }
}
