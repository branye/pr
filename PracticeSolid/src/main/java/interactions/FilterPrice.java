package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import static userinterfaces.SeleccionarHotelPage.LOWER_PRICE_HOTEL_TITTLE;
import static utils.Formater.formatPrice;
import static utils.GetPrice.lower;

public class FilterPrice implements Interaction {

    private Target element;
    public FilterPrice(Target element){
        this.element=element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOWER_PRICE_HOTEL_TITTLE.of(formatPrice(lower(actor, element)))));
    }

    public static FilterPrice byLower(Target target){
        return Tasks.instrumented(FilterPrice.class, target);
    }
}
