Feature: Escoger hotel

  @TestCase1
  Scenario: Escoger el hotel con el precio mas bajo
    Given se accede a la pagina para reservar hotel
    When se busca el hotel con la siguiente informacion
      |checkIn    |checkOut     |numAdultos   |numNinos  |
      |09/07/2020 |09/07/2020   |2            |2        |
    And selecciona el hospedaje con el precio mas bajo
    Then verificar que el detalle de la reserva contenga la siguiente informacion
      |caracteristica|
      |SPA           |