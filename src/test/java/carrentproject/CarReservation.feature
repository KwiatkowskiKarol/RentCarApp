Feature: Car_Reservation
  Scenario: Create New Car Reservation
    Given Create New Car Reservation
    When reservation get own cars <listOfReservation>
    Then user can show <listOfReservation>

Scenario: Delete car reservation
  Given Delete car reservation <listOfReservation>
  When car reservation got own id
  Then user can delete reservation