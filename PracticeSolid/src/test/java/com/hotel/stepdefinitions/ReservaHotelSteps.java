package com.hotel.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.TravelExceptions;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.IsEqual;
import questions.CheckIfHotelIncludes;
import tasks.GoTravelsPage;
import tasks.OpenPage;
import tasks.Reservar;
import io.cucumber.datatable.DataTable;
import tasks.SelectHotel;


import java.util.List;
import java.util.Map;

import static exceptions.TravelExceptions.SELECTED_HOTEL_DOES_NOT_CONTAINS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReservaHotelSteps {
    @Before
    public void initialConfig(){
        setTheStage(new OnlineCast());
        theActorCalled("user");
    }

    @After
    public void TearDown(){
        closeDriver();
        System.out.printLn("cerrar tarea");
    }

    @Given("se accede a la pagina para reservar hotel")
    public void seAccedeALaPaginaParaReservarHotel() {
        theActorInTheSpotlight().attemptsTo(OpenPage.travels());
        theActorInTheSpotlight().attemptsTo(GoTravelsPage.phpPage());
    }

    @When("se busca el hotel con la siguiente informacion")
    public void seBuscaElHotelConLaSiguienteInformacion(DataTable table) {
        List<List<String>> hotel = table.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(Reservar.hotel(hotel));
    }

    @When("selecciona el hospedaje con el precio mas bajo")
    public void seleccionaElHospedajeConElPrecioMasBajo() {
        theActorInTheSpotlight().attemptsTo(SelectHotel.byLowerPrice());
    }

    @Then("verificar que el detalle de la reserva contenga la siguiente informacion")
    public void verificarQueElDetalleDeLaReservaContengaLaSiguienteInformacion(DataTable table) {
        List<List<String>> hotel = table.asLists(String.class);
        theActorInTheSpotlight().should(seeThat("Contenga en sus detalles SPA",
                CheckIfHotelIncludes.spa(),
                equalTo(hotel.get(1).get(0))).orComplainWith(TravelExceptions.class, SELECTED_HOTEL_DOES_NOT_CONTAINS));
    }

}
