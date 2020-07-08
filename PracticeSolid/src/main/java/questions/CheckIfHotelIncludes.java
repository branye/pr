package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.SeleccionarHotelPage;

public class CheckIfHotelIncludes implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SeleccionarHotelPage.TXT_SPA_CHARACTERISTIC).viewedBy(actor).asString();
    }

    public static CheckIfHotelIncludes spa(){
        return new CheckIfHotelIncludes();
    }
}
