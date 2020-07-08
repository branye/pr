package tasks;

import interactions.FilterPrice;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import userinterfaces.SeleccionarHotelPage;

import static userinterfaces.SeleccionarHotelPage.COOKIES_BUTTON;
import static userinterfaces.SeleccionarHotelPage.TXT_PRICE_TAG;

public class SelectHotel implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Check.whether(COOKIES_BUTTON.resolveFor(actor).isVisible())
                .andIfSo(Click.on(COOKIES_BUTTON)));
        actor.attemptsTo(FilterPrice.byLower(TXT_PRICE_TAG));
    }

    public static SelectHotel byLowerPrice(){
        return Tasks.instrumented(SelectHotel.class);
    }
}
