package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


@DefaultUrl("https://phptravels.com/demo/")
//@DefaultUrl("https://www.phptravels.net/home")
public class HomePage extends PageObject{
    public static final Target TRAVELS_PAGE =
            Target.the("campo - ciudad destino").located(By.xpath("//*[@id=\"Main\"]/section[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div/a"));
}
