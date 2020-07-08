package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebDriver;
import userinterfaces.HomePage;

import java.util.ArrayList;

public class SwitchWindow implements Interaction {
    private HomePage homepage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = homepage.getDriver();
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    public static SwitchWindow tab() {
        return Tasks.instrumented(SwitchWindow.class);
    }
}
