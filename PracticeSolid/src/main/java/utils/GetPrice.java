package utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetPrice {

    public static int lower(Actor actor, Target target){
        List<WebElementFacade> prices = target.resolveAllFor(actor);
        List<Integer> values = new ArrayList<>();
        for (int i=1; i< prices.size(); i++){
            values.add(Integer.valueOf(prices.get(i).getText().replace(" ","").replace("$","")));
        }
        return values.get(values.indexOf(Collections.min(values)));
    }
}
