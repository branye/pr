package com.hotel.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/travel_hostel.feature",
        glue = "com.hotel.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class ReservaHotel {
}
