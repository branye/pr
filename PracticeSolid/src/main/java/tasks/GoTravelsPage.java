package tasks;

import interactions.SwitchWindow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterfaces.HomePage.TRAVELS_PAGE;

public class GoTravelsPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TRAVELS_PAGE));
        actor.attemptsTo(SwitchWindow.tab());
    }

    public static GoTravelsPage phpPage() {
        return Tasks.instrumented(GoTravelsPage.class);
    }
}
